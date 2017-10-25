package ru.webmarket.service;

import org.springframework.stereotype.Service;
import ru.webmarket.entity.dto.CategoryDTO;
import ru.webmarket.entity.dto.ProductDTO;

import java.util.List;

/**
 * @author Сергей
 */
public interface ProductService {

    void addProduct(ProductDTO productDTO);

    Long addProductAndGetId (ProductDTO productDTO);

    ProductDTO getProduct(Long id);

    void editProduct(ProductDTO productDTO);

    void deleteProduct(Long id);

    List<ProductDTO> getProducts();

    List<CategoryDTO> getCategories(ProductDTO productDTO);

    ProductDTO findByName(String name);
}
