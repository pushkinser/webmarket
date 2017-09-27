package ru.webmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webmarket.entity.CategoryDTO;

public interface CategoryRepository extends JpaRepository<CategoryDTO, Long> {
}
