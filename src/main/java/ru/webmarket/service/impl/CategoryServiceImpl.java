//package ru.webmarket.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import ru.webmarket.entity.Category;
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
//    public void addCategory(Category categoryDTO) {
//        categoryRepository.save(categoryDTO);
//    }
//
//    @Override
//    public Category getCategory(Long id) {
//        return categoryRepository.findOne(id);
//    }
//
//    @Override
//    public void editCategory(Category toEditCategoryDTO) {
//        Category categoryDTO = categoryRepository.findOne(toEditCategoryDTO.getId());
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
//    public List<Category> getAllCategories() {
//        return categoryRepository.findAll();
//    }
//
//    @Override
//    public List<Product> getAllProducts(Category categoryDTO) {
//        return null;
//    }
//
//    @Override
//    public Category findByName(String name) {
//        return null;
//    }
//}
