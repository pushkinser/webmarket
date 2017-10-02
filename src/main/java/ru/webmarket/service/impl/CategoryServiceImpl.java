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
        if (category != null) categoryRepository.save(category);
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        CategoryDTO categoryDTO = CategoryConvector.entityToDto(categoryRepository.findOne(id));
        if (categoryDTO == null) return null;
        return categoryDTO;
    }

    @Override
    public void editCategory(CategoryDTO toEditCategoryDTO) {
        Category category = categoryRepository.findOne(toEditCategoryDTO.getId());
        if (category != null) {
            category.setName(toEditCategoryDTO.getName());
        }
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findOne(id);
        if (category != null) categoryRepository.delete(id);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categoryDTOS = CategoryConvector.entityToDto(categoryRepository.findAll());
        if (categoryDTOS.isEmpty()) return null;
        return categoryDTOS;
    }

    @Override
    public CategoryDTO findByName(String name) {
        Category category = categoryRepository.findByName(name);
        if (category == null) return null;
        return CategoryConvector.entityToDto(category);
    }
}
