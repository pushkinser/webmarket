package ru.webmarket.model.mapper;

import ru.webmarket.model.dto.ProductDTO;
import ru.webmarket.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMap {

    public static ProductDTO toDto(Product product) {
        if ( product == null) return null;
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());

        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        if ( productDTO == null) return null;
        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());

        return product;
    }

    public static List<ProductDTO> toDto(List<Product> products) {
        if ( products == null) return null;
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product product : products) {
            if (product == null) continue;
            productDTOS.add(toDto(product));

        }

        return productDTOS;
    }

    public static List<Product> toEntity(List<ProductDTO> productDTOS) {
        if ( productDTOS == null) return null;
        List<Product> products = new ArrayList<>();

        for (ProductDTO productDTO : productDTOS) {
            if (productDTO == null) continue;
            products.add(toEntity(productDTO));

        }

        return products;
    }

}