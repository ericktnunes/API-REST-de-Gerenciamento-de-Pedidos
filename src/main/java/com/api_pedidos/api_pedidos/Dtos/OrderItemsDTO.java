package com.api_pedidos.api_pedidos.Dtos;

import com.api_pedidos.api_pedidos.Entity.OrderItems;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDTO {
    private Long id;
    private String productName;
    private int quantity;
    private double price;

    public OrderItemsDTO(OrderItems orderItems) {
        BeanUtils.copyProperties(orderItems, this);
    }
}
