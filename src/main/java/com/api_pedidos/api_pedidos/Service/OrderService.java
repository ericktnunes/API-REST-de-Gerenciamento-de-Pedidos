package com.api_pedidos.api_pedidos.Service;

import com.api_pedidos.api_pedidos.Dtos.OrderDTO;
import com.api_pedidos.api_pedidos.Entity.Order;
import com.api_pedidos.api_pedidos.Repository.OrderListRepository;
import com.api_pedidos.api_pedidos.Repository.OrderRepository;
import org.springframework.beans.BeanUtils;
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

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()){
            return orderOptional.get();
        }
        return null;
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
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
