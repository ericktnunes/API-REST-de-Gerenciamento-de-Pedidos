package com.api_pedidos.api_pedidos.Dtos;

import com.api_pedidos.api_pedidos.Entity.OrderItems;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
public class OrderItemsDTO {
    private String productName;
    private int quantity;
    private double price;

    public OrderItemsDTO(OrderItems orderItems) {
        BeanUtils.copyProperties(orderItems, this);
    }
}
