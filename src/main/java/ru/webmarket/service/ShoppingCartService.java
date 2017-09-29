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

    List<ShoppingCartDTO> getShoppingCart();

    ShoppingCartDTO getShoppingCart(Long id);

    void editShoppingCart(ShoppingCartDTO shoppingCartDTO);

    void deleteShoppingCart(Long id);

    void addProduct(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO);

    void deleteProduct(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO);

    List<ProductDTO> getProduct(Long id);

    Double getTotal (ShoppingCartDTO shoppingCartDTO);
}
