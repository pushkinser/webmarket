package ru.webmarket.entity.converter;

import ru.webmarket.entity.Category;
import ru.webmarket.entity.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Сергей
 */
public class CategoryConvecter {

    public static Category dtoToEntity(CategoryDTO categoryDTO) {
        if (categoryDTO == null) return null;
        Category category = new Category();

        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());

        return category;
    }

    public static CategoryDTO entityToDto(Category category) {
        if (category == null) return null;
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }

    public static List<Category> dtoToEntity(List<CategoryDTO> categoryDTOS){
        if (categoryDTOS == null) return null;
        List<Category> categories = new ArrayList<>();
        for (CategoryDTO categoryDTO: categoryDTOS) {
            if (categoryDTO == null) continue;
            categories.add(CategoryConvecter.dtoToEntity(categoryDTO));
        }
        return categories;
    }

    public static List<CategoryDTO> entityToDto(List<Category> categories) {
        if (categories == null) return null;
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category: categories) {
            if (category == null) return null;
            categoryDTOS.add(CategoryConvecter.entityToDto(category));
        }
        return categoryDTOS;
    }

}
