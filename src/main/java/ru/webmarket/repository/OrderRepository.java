package ru.webmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webmarket.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
