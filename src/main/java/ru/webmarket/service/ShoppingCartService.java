package ru.webmarket.service;

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

    List<ProductDTO> getProduct(Long id);
}
