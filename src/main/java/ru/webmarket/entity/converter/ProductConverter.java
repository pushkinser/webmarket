package ru.webmarket.entity.converter;

import org.springframework.security.access.method.P;
import ru.webmarket.entity.Product;
import ru.webmarket.entity.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Сергей
 */
public class ProductConverter {

    public static ProductDTO entityToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategories(CategoryConvector.entityToDto(product.getCategories()));

        return productDTO;
    }

    public static Product dtoToEntity(ProductDTO productDTO) {
        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategories(CategoryConvector.dtoToEntity(productDTO.getCategories()));

        return product;
    }

    public static List<ProductDTO> entityToDto(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product product : products) {

            productDTOS.add(ProductConverter.entityToDto(product));

        }

        return productDTOS;
    }

    public static List<Product> dtoToEntity(List<ProductDTO> productDTOS) {
        List<Product> products = new ArrayList<>();

        for (ProductDTO productDTO : productDTOS) {

            products.add(ProductConverter.dtoToEntity(productDTO));

        }

        return products;
    }
}
