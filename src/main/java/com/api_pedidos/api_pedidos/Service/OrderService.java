package com.api_pedidos.api_pedidos.Service;

import com.api_pedidos.api_pedidos.Dtos.OrderCreateDTO;
import com.api_pedidos.api_pedidos.Dtos.OrderDTO;
import com.api_pedidos.api_pedidos.Entity.Order;
import com.api_pedidos.api_pedidos.Entity.OrderItems;
import com.api_pedidos.api_pedidos.Repository.OrderListRepository;
import com.api_pedidos.api_pedidos.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderDTO createOrder(OrderCreateDTO orderCreateDTO) {

        Order order = new Order(orderCreateDTO);

        if(orderCreateDTO.getItems() != null){
            Order finalOrder = order;
            List<OrderItems> items = orderCreateDTO.getItems().stream()
                    .map(orderItemsDTO -> {
                        OrderItems orderItems = new OrderItems();
                        orderItems.setOrder(finalOrder);
                        orderItems.setQuantity(orderItemsDTO.getQuantity());
                        orderItems.setPrice(orderItemsDTO.getPrice());
                        orderItems.setProductName(orderItemsDTO.getProductName());
                        return orderItems;
                    })
                    .collect(Collectors.toList());


            order.setItems(items);
        }

        order = orderRepository.save(order);
        return new OrderDTO(order);
    }

    public List<OrderDTO> findAllOrders() {
        var order = orderRepository.findAll();
        return order.stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    public OrderDTO findById(Long id){
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()){
            var order = orderOptional.get();
            return new OrderDTO(order);
        }
        return null;
    }

    @Transactional
    public Order updateOrder(Long id, OrderDTO orderDTO) {
        // find order by id in the database
        Optional<Order> existingOrderOptional = orderRepository.findById(id);

        if (!existingOrderOptional.isPresent()) {
            throw new RuntimeException("Order with ID " + id + " not found!");
        }

        Order existingOrder = existingOrderOptional.get();

        // Att with DTO data
        existingOrder.setCustomerName(orderDTO.getCustomerName());
        existingOrder.setStatus(orderDTO.getStatus());

        // Att orderItems
        if (orderDTO.getItems() != null) {
            List<OrderItems> updatedItems = orderDTO.getItems().stream()
                    .map(orderItemsDTO -> {
                        // Verificando se o item já existe na ordem
                        Optional<OrderItems> existingItemOpt = existingOrder.getItems()
                                .stream()
                                .filter(i -> i.getId().equals(orderItemsDTO.getId()))
                                .findFirst();

                        OrderItems orderItem = existingItemOpt.orElse(new OrderItems());
                        orderItem.setProductName(orderItemsDTO.getProductName());
                        orderItem.setQuantity(orderItemsDTO.getQuantity());
                        orderItem.setPrice(orderItemsDTO.getPrice());
                        orderItem.setOrder(existingOrder);
                        return orderItem;
                    })
                    .collect(Collectors.toList());

            existingOrder.setItems(updatedItems); // Atualizando a lista de itens
        }
        return orderRepository.save(existingOrder);
    }

    public Order deleteOrder(Long id){
        Optional<Order> orderOptional = orderRepository.findById(id);

        if(orderOptional.isPresent()){
            Order orderDelete = orderOptional.get();

            orderRepository.deleteById(id);
            return orderDelete;
        }
        return null;
    }

}
