package ru.webmarket.service;

import org.springframework.stereotype.Service;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.entity.dto.ShoppingCartDTO;

import java.util.List;

/**
 * @author Сергей
 */

public interface ShoppingCartService {

    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    List<ShoppingCartDTO> getShoppingCarts();

    ShoppingCartDTO getShoppingCart(Long id);

    ShoppingCartDTO getShoppingCartByUserId (Long id);

    void editShoppingCart(ShoppingCartDTO shoppingCartDTO);

    void addProduct(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO);

    void addProduct(ShoppingCartDTO shoppingCartDTO, Long id);

    void deleteProduct(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO);

    List<ProductDTO> getProducts(ShoppingCartDTO shoppingCartDTO);

    Double getTotal (ShoppingCartDTO shoppingCartDTO);

    int getCountProducts (ShoppingCartDTO shoppingCartDTO);

    void editProductCount(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO, int count );

    void deleteShoppingCart(Long id);
}
