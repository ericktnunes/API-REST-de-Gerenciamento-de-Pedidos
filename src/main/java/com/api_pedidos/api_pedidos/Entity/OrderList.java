package com.api_pedidos.api_pedidos.Entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

@Entity
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String productName;

    @NotNull
    private int quantity;

    @NotNull
    private double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

}
