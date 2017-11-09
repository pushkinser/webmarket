package ru.webmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webmarket.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Product findByName (String name);

}
