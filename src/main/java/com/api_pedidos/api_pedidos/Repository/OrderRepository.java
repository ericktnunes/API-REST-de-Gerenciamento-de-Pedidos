package com.api_pedidos.api_pedidos.Repository;

import com.api_pedidos.api_pedidos.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
