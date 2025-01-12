package com.api_pedidos.api_pedidos.Repository;

import com.api_pedidos.api_pedidos.Entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderItems, Long> {
}
