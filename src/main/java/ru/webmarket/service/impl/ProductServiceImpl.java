package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.model.dto.ProductDTO;
import ru.webmarket.model.mapper.ProductMap;
import ru.webmarket.repository.ProductRepository;
import ru.webmarket.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Возвращает сохранненый продукт.
     */
    @Override
    public ProductDTO add(ProductDTO productDTO) {
        if (productDTO == null) return null;
        return ProductMap.toDto(productRepository.save(ProductMap.toEntity(productDTO)));
    }

    /**
     * Возвращает продукт по идентификатору.
     */
    @Override
    public ProductDTO get(Long id) {
        return ProductMap.toDto(productRepository.findOne(id));
    }

    /**
     * Возвращает весь список продуктов.
     */
    @Override
    public List<ProductDTO> getAll() {
        return ProductMap.toDto(productRepository.findAll());
    }
}
