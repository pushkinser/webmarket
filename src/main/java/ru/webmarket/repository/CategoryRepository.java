package ru.webmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webmarket.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByName (String name);
}
