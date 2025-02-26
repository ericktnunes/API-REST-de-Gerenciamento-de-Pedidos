package com.api_pedidos.api_pedidos.Controller;

import com.api_pedidos.api_pedidos.Dtos.OrderDTO;
import com.api_pedidos.api_pedidos.Entity.Order;
import com.api_pedidos.api_pedidos.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public List<OrderDTO> findAllOrders(){
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDTO findOrdersById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrders(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Order deleteOrders (@PathVariable("id") Long id){
        return orderService.deleteOrder(id);
    }

    @PutMapping("/{id}")
    public Order updateOrders(@PathVariable("id") Long id, @RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(id, orderDTO);
    }

}
