package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.Product;
import ru.webmarket.entity.converter.CategoryConvector;
import ru.webmarket.entity.converter.ProductConverter;
import ru.webmarket.entity.dto.CategoryDTO;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.repository.ProductRepository;
import ru.webmarket.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = productRepository.findOne(productDTO.getId());
        if (product != null) productRepository.save(ProductConverter.dtoToEntity(productDTO));
    }

    @Override
    public ProductDTO getProduct(Long id) {
        Product product = productRepository.findOne(id);
        if (product == null) return null;
        return ProductConverter.entityToDto(product);
    }

    @Override
    public void editProduct(ProductDTO productDTO) {
        Product product = productRepository.findOne(productDTO.getId());
        if (product != null) {
            product.setName(productDTO.getName());
            product.setCategories(CategoryConvector.dtoToEntity(productDTO.getCategories()));
            product.setPrice(productDTO.getPrice());
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findOne(id);
        if (product != null) productRepository.delete(id);
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        productDTOS = ProductConverter.entityToDto(productRepository.findAll());
        if (productDTOS == null) return null;
        return productDTOS;
    }

    @Override
    public List<CategoryDTO> getAllCategory(ProductDTO productDTO) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categoryDTOS = productDTO.getCategories();
        if (categoryDTOS.isEmpty()) return null;
        return categoryDTOS;
    }

    @Override
    public ProductDTO findByName(String name) {
        Product product = productRepository.findByName(name);
        if (product == null) return null;
        return ProductConverter.entityToDto(product);
    }
}
