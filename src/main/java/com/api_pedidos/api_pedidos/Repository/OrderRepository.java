package com.api_pedidos.api_pedidos.Repository;

import com.api_pedidos.api_pedidos.Entity.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @EntityGraph(attributePaths = "items")  // Isso garante que os itens sejam carregados
    List<Order> findAll();

    @EntityGraph(attributePaths = "items")
    Optional<Order> findById(Long id);

}
