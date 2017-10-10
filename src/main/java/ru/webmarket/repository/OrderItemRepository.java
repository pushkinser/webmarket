package ru.webmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webmarket.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
