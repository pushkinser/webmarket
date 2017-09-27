package ru.webmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webmarket.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
