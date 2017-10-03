package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.Product;
import ru.webmarket.entity.converter.CategoryConvecter;
import ru.webmarket.entity.converter.ProductConverter;
import ru.webmarket.entity.dto.CategoryDTO;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.repository.ProductRepository;
import ru.webmarket.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = productRepository.findOne(productDTO.getId());
        if (product != null) productRepository.save(ProductConverter.dtoToEntity(productDTO));
    }

    @Override
    public ProductDTO getProduct(Long id) {
        return ProductConverter.entityToDto(productRepository.findOne(id));
    }

    @Override
    public void editProduct(ProductDTO productDTO) {
        Product product = productRepository.findOne(productDTO.getId());
        if (product != null) {
            product.setName(productDTO.getName());
            product.setCategories(CategoryConvecter.dtoToEntity(productDTO.getCategories()));
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
        return ProductConverter.entityToDto(productRepository.findAll());
    }

    @Override
    public List<CategoryDTO> getAllCategory(ProductDTO productDTO) {
        return productDTO.getCategories();
    }

    @Override
    public ProductDTO findByName(String name) {
        return ProductConverter.entityToDto(productRepository.findByName(name));
    }
}
