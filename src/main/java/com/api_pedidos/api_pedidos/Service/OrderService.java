package com.api_pedidos.api_pedidos.Service;

import com.api_pedidos.api_pedidos.Dtos.OrderDTO;
import com.api_pedidos.api_pedidos.Dtos.OrderItemsDTO;
import com.api_pedidos.api_pedidos.Entity.Order;
import com.api_pedidos.api_pedidos.Repository.OrderListRepository;
import com.api_pedidos.api_pedidos.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderListRepository orderListRepository;


    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<OrderDTO> findAllOrders(){
        return orderRepository.findAll().stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    public OrderDTO findById(Long id){
        return orderRepository.findById(id)
                .map(OrderDTO::new).
                orElseThrow(() -> new RuntimeException("Order not found!"));
    }

    public Order updateOrder(Order order){
        var updateOrder = orderRepository.save(order);
        return updateOrder;
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
