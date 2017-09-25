package ru.webmarket.repository;

import org.springframework.data.repository.CrudRepository;
import ru.webmarket.entity.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
