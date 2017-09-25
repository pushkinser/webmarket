package ru.webmarket.repository;

import org.springframework.data.repository.CrudRepository;
import ru.webmarket.entity.Order;

public interface OrderRepository extends CrudRepository <Order, Long> {
}
