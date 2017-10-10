package ru.webmarket.service;

import org.springframework.stereotype.Service;
import ru.webmarket.entity.Category;
import ru.webmarket.entity.dto.CategoryDTO;
import ru.webmarket.entity.dto.ProductDTO;

import java.util.List;

public interface CategoryService {

    void addCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategory(Long id);

    void editCategory(CategoryDTO categoryDTO);

    void deleteCategory(Long id);

    List<CategoryDTO> getCategories();

    CategoryDTO findByName(String name);
}
