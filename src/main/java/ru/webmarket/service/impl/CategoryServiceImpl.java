//package ru.webmarket.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import ru.webmarket.entity.CategoryDTO;
//import ru.webmarket.entity.Product;
//import ru.webmarket.repository.CategoryRepository;
//import ru.webmarket.service.CategoryService;
//
//import java.util.List;
//
//
//
//public class CategoryServiceImpl implements CategoryService {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Override
//    public void addCategory(CategoryDTO categoryDTO) {
//        categoryRepository.save(categoryDTO);
//    }
//
//    @Override
//    public CategoryDTO getCategory(Long id) {
//        return categoryRepository.findOne(id);
//    }
//
//    @Override
//    public void editCategory(CategoryDTO toEditCategoryDTO) {
//        CategoryDTO categoryDTO = categoryRepository.findOne(toEditCategoryDTO.getId());
//
//        toEditCategoryDTO.setName(categoryDTO.getName());
//    }
//
//    @Override
//    public void deleteCategory(Long id) {
//        categoryRepository.delete(id);
//    }
//
//    @Override
//    public List<CategoryDTO> getAllCategories() {
//        return categoryRepository.findAll();
//    }
//
//    @Override
//    public List<Product> getAllProducts(CategoryDTO categoryDTO) {
//        return null;
//    }
//
//    @Override
//    public CategoryDTO findByName(String name) {
//        return null;
//    }
//}
