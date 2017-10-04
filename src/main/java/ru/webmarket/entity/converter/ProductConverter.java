package ru.webmarket.entity.converter;

import ru.webmarket.entity.Product;
import ru.webmarket.entity.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Сергей
 */
public class ProductConverter {

    public static ProductDTO entityToDto(Product product) {
        if ( product == null) return null;
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategories(CategoryConverter.entityToDto(product.getCategories()));

        return productDTO;
    }

    public static Product dtoToEntity(ProductDTO productDTO) {
        if ( productDTO == null) return null;
        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategories(CategoryConverter.dtoToEntity(productDTO.getCategories()));

        return product;
    }

    public static List<ProductDTO> entityToDto(List<Product> products) {
        if ( products == null) return null;
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product product : products) {
            if (product == null) continue;
            productDTOS.add(ProductConverter.entityToDto(product));

        }

        return productDTOS;
    }

    public static List<Product> dtoToEntity(List<ProductDTO> productDTOS) {
        if ( productDTOS == null) return null;
        List<Product> products = new ArrayList<>();

        for (ProductDTO productDTO : productDTOS) {
            if (productDTO == null) continue;
            products.add(ProductConverter.dtoToEntity(productDTO));

        }

        return products;
    }
}
