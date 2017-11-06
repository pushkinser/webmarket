package ru.webmarket.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.webmarket.model.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long id);

}
