package com.api_pedidos.api_pedidos.Service;

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

    public Order createOrder(OrderDTO orderDTO) {

        Order order = new Order(orderDTO);

        if(orderDTO.getItems() != null){
            for(OrderItems item : orderDTO.getItems()){
                item.setOrder(order);
                order.setItems(orderDTO.getItems());
            }
        }

        return orderRepository.save(order);
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
            // add new items
            for (OrderItems item : orderDTO.getItems()) {

                //if exist this item, get the item
                Optional<OrderItems> orderItemsOptional = existingOrder.getItems()
                                .stream()
                                .filter(i -> i.getId().equals(item.getId()))
                                .findFirst();

                if(orderItemsOptional.isPresent()){
                    //att the exist item
                    OrderItems existingItem = orderItemsOptional.get();
                    existingItem.setProductName(item.getProductName());
                    existingItem.setPrice(item.getPrice());
                    existingItem.setQuantity(item.getQuantity());
                } else {
                    //if don't exist, create new item
                    item.setOrder(existingOrder);
                    existingOrder.setItems(orderDTO.getItems());
                }
            }
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
