package com.api_pedidos.api_pedidos.Dtos;

import com.api_pedidos.api_pedidos.Entity.Order;
import com.api_pedidos.api_pedidos.Entity.OrderItems;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;
public class OrderDTO {
    private String customerName;
    private String status;
    private List<OrderItems> items;


    //Construct DTO by order properties
    public OrderDTO(Order order) {
        customerName = order.getCustomerName();
        status = order.getStatus();
        items = order.getItems();
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItems> getItems() {
        return items;
    }

    public void setItems(List<OrderItems> items) {
        this.items = items;
    }
}
