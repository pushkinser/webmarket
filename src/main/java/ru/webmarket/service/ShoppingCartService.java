package ru.webmarket.service;

import org.springframework.stereotype.Service;
import ru.webmarket.entity.dto.OrderItemDTO;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.entity.dto.ShoppingCartDTO;

import java.util.List;

/**
 * @author Сергей
 */

  // Перепланирование сервиса
    /*
    void             Создание корзины. 
    void             Удаление корзины.
    boolean          Пустотота корзины.
    List<ProductDTO> Получить текующие позиции из корзины.
    int              Текущая стоимость корзины.
    void             Добавление товара.
    void             Удаление товара.
    void             Изменение количества покупаемого товара.
    void             Очистить корзину от товаров.
    void             Оформить заказ.
    
    Тогда, как сделать заказ, если корзина содержит order?
    Нужно отличать order-заказы от order-корзин.
    
    
    
    */

public interface ShoppingCartService {

    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    List<ShoppingCartDTO> getShoppingCarts();

    ShoppingCartDTO getShoppingCart(Long id);

    ShoppingCartDTO getShoppingCartByUserId (Long id);

    void editShoppingCart(ShoppingCartDTO shoppingCartDTO);

    public void editShoppingCart(ShoppingCartDTO shoppingCartDTO, OrderItemDTO orderItemDTO);

    void addProduct(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO);

    void addProduct(ShoppingCartDTO shoppingCartDTO, Long id);

    void addProduct(ShoppingCartDTO shoppingCartDTO, Long id, int count);

    void deleteProducts(ShoppingCartDTO shoppingCartDTO);

    void deleteProduct(ShoppingCartDTO shoppingCartDTO,  Long id);

    List<ProductDTO> getProducts(ShoppingCartDTO shoppingCartDTO);

    Double getTotal (ShoppingCartDTO shoppingCartDTO);

    int getCountProducts (ShoppingCartDTO shoppingCartDTO);

    void editProductCount(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO, int count );

    void deleteShoppingCart(Long id);
}
