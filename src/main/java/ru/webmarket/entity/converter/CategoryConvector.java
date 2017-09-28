package ru.webmarket.entity.converter;

import ru.webmarket.entity.Category;
import ru.webmarket.entity.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Сергей
 */
public class CategoryConvector {

    public static Category dtoToentity(CategoryDTO categoryDTO) {
        Category category = new Category();

        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());

        return category;
    }

    public static CategoryDTO entityToDto(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }

    public static List<Category> dtoToEntity(List<CategoryDTO> categoryDTOS){
        List<Category> categories = new ArrayList<>();

        for (CategoryDTO categoryDTO: categoryDTOS) {
            categories.add(CategoryConvector.dtoToentity(categoryDTO));
        }

        return categories;
    }

    public static List<CategoryDTO> entityToDto(List<Category> categories) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for (Category category: categories) {
            categoryDTOS.add(CategoryConvector.entityToDto(category));
        }

        return categoryDTOS;
    }

}
