package com.api_pedidos.api_pedidos.Dtos;

import com.api_pedidos.api_pedidos.Entity.Enum.PaymentMethod;
import com.api_pedidos.api_pedidos.Entity.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class OrderCreateDTO {
    private String customerName;
    private Status status;
    private List<OrderItemsDTO> items;
    private PaymentMethod paymentMethod;
    private String deliveryAddress;
}
