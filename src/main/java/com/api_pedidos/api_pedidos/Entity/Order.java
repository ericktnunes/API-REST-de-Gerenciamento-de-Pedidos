package com.api_pedidos.api_pedidos.Entity;

import com.api_pedidos.api_pedidos.Dtos.OrderCreateDTO;
import com.api_pedidos.api_pedidos.Dtos.OrderDTO;
import com.api_pedidos.api_pedidos.Entity.Enum.PaymentMethod;
import com.api_pedidos.api_pedidos.Entity.Enum.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_orders")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String customerName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItems> items;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @NotNull
    private String deliveryAddress;

    //Entity to DTO
    public Order(OrderDTO orderDTO){
        BeanUtils.copyProperties(orderDTO, this);
    }

    //Entity to DTO of creation
    public Order(OrderCreateDTO orderCreateDTO){
        BeanUtils.copyProperties(orderCreateDTO, this);
    }

}
