package ru.webmarket.service;

import ru.webmarket.model.dto.*;

public interface ShoppingCartService {

    ShoppingCartDTO get (Long shoppingCartId);

    ShoppingCartDTO addByUser (UserDTO userDTO);

    ShoppingCartDTO getByUserId (Long userId);

    OrderDTO getOrder (ShoppingCartDTO shoppingCartDTO);

    void addProduct (ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO);

    void addProduct (ShoppingCartDTO shoppingCartDTO, Long productId);

    OrderItemDTO addProductAndReturnItem (ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO);

    void editCountOrderItem (OrderItemDTO orderItemDTO, Integer count);

    void editCountOrderItem (Long orderItemId, Integer count);

    void deleteOrderItem (OrderItemDTO orderItemDTO);

    void deleteOrderItem (Long orderItemId);

    void deleteOrderItems (ShoppingCartDTO shoppingCartDTO);

    Double getCount (ShoppingCartDTO shoppingCartDTO);

}
