package ru.webmarket.service.impl;

import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.service.ShoppingCartService;

import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Override
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {

    }

    @Override
    public List<ShoppingCartDTO> getShoppingCart() {
        return null;
    }

    @Override
    public ShoppingCartDTO getShoppingCart(Long id) {
        return null;
    }

    @Override
    public void editShoppingCart(ShoppingCartDTO shoppingCartDTO) {

    }

    @Override
    public void deleteShoppingCart(Long id) {

    }

    @Override
    public void addProduct(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO) {

    }

    @Override
    public void deleteProduct(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO) {

    }

    @Override
    public List<ProductDTO> getProducts(ShoppingCartDTO shoppingCartDTO) {
        return null;
    }

    @Override
    public Double getTotal(ShoppingCartDTO shoppingCartDTO) {
        return null;
    }

    @Override
    public int getCountProducts(ShoppingCartDTO shoppingCartDTO) {
        return 0;
    }
}
