package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.entity.Category;
import ru.webmarket.entity.converter.CategoryConvector;
import ru.webmarket.entity.dto.CategoryDTO;
import ru.webmarket.repository.CategoryRepository;
import ru.webmarket.service.CategoryService;

import java.util.ArrayList;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        Category category = CategoryConvector.dtoToentity(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        CategoryDTO categoryDTO = CategoryConvector.entityToDto(categoryRepository.findOne(id));
        return categoryDTO;
    }

    @Override
    public void editCategory(CategoryDTO toEditCategoryDTO) {
        Category categoryDTO = categoryRepository.findOne(toEditCategoryDTO.getId());

        toEditCategoryDTO.setName(categoryDTO.getName());
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories) {
            categoryDTOS.add(CategoryConvector.entityToDto(category));
        }
        return categoryDTOS;
    }

    @Override
    public Category findByName(String name) {
        return null;
    }
}
