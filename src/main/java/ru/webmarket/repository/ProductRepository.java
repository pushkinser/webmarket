package ru.webmarket.repository;

import org.springframework.data.repository.CrudRepository;
import ru.webmarket.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
