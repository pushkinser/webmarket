package ru.webmarket.repository;

import org.springframework.data.repository.CrudRepository;
import ru.webmarket.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
