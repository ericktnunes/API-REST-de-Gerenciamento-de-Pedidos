package com.api_pedidos.api_pedidos.Dtos;

import com.api_pedidos.api_pedidos.Entity.Enum.Status;
import com.api_pedidos.api_pedidos.Entity.Order;
import com.api_pedidos.api_pedidos.Entity.OrderItems;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String customerName;
    private Status status;
    private List<OrderItemsDTO> items;


    //Construct DTO by order properties
    public OrderDTO(Order order) {
        BeanUtils.copyProperties(order, this);

        //convert OrderItems to OrderItemsDTO
        if(order.getItems() != null){
            this.items = order.getItems().stream()
                    .map(OrderItemsDTO::new)
                    .collect(Collectors.toList());
        }
    }
}
