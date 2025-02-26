package com.api_pedidos.api_pedidos.Dtos;

import com.api_pedidos.api_pedidos.Entity.Order;
import com.api_pedidos.api_pedidos.Entity.OrderItems;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String customerName;
    private String status;
    private List<OrderItems> items;


    //Construct DTO by order properties
    public OrderDTO(Order order) {
        BeanUtils.copyProperties(order, this);
    }
}
