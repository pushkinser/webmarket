package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.Category;
import ru.webmarket.entity.converter.CategoryConvector;
import ru.webmarket.entity.dto.CategoryDTO;
import ru.webmarket.repository.CategoryRepository;
import ru.webmarket.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        Category category = CategoryConvector.dtoToEntity(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        CategoryDTO categoryDTO = CategoryConvector.entityToDto(categoryRepository.findOne(id));
        return categoryDTO;
    }

    @Override
    public void editCategory(CategoryDTO toEditCategoryDTO) {
        Category category = categoryRepository.findOne(toEditCategoryDTO.getId());

        category.setName(toEditCategoryDTO.getName());
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return CategoryConvector.entityToDto(categoryRepository.findAll());
    }

    @Override
    public CategoryDTO findByName(String name) {
        return CategoryConvector.entityToDto(categoryRepository.findByName(name));
    }
}
