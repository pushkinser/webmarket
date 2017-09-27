package ru.webmarket.service;

import org.springframework.stereotype.Service;
import ru.webmarket.entity.Category;
import ru.webmarket.entity.dto.ProductDTO;

import java.util.List;

@Service
public interface CategoryService {

    void addCategory(Category categoryDTO);

    Category getCategory(Long id);

    void editCategory(Category categoryDTO);

    void deleteCategory(Long id);

    List<Category> getAllCategories();

    List<ProductDTO> getAllProducts(Category categoryDTO);

    Category findByName(String name);

}
