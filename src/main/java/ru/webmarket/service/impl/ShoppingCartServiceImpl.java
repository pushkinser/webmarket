package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.model.dto.*;
import ru.webmarket.model.mapper.ShoppingCartMap;
import ru.webmarket.repository.ShoppingCartRepository;
import ru.webmarket.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    private final OrderItemServiceImpl orderItemService;

    private final ProductServiceImpl productService;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, OrderItemServiceImpl orderItemService, ProductServiceImpl productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.orderItemService = orderItemService;
        this.productService = productService;
    }

    /**
     * Вохвращает корзину пользователя по идентификатору корзины.
     */
    @Override
    public ShoppingCartDTO get(Long shoppingCartId) {
        return ShoppingCartMap.toDto(shoppingCartRepository.findOne(shoppingCartId));
    }

    /**
     * Возвращает true, если пустая корзина
     */
    @Override
    public Boolean isEmpty(ShoppingCartDTO shoppingCartDTO) {
        return orderItemService.getOrderItemByOrder(shoppingCartDTO.getOrder()).isEmpty();
    }

    /**
     * Сохраняет пустую корзину для пользователя.
    */
    @Override
    public ShoppingCartDTO addByUser(UserDTO userDTO) {
        if (userDTO == null) return null;

        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUser(userDTO);

        shoppingCartDTO.setOrder(orderDTO);
        shoppingCartDTO.setUser(userDTO);

        return ShoppingCartMap.toDto(shoppingCartRepository.save(ShoppingCartMap.toEntity(shoppingCartDTO)));
    }

    /**
     * Вохвращает корзину пользователя по его идентификатору.
     */
    @Override
    public ShoppingCartDTO getByUserId(Long userId) {
        return ShoppingCartMap.toDto(shoppingCartRepository.findByUser_Id(userId));
    }

    /**
     * Возвращает заказ корзины.
     */
    @Override
    public OrderDTO getOrder(ShoppingCartDTO shoppingCartDTO) {
        return shoppingCartDTO.getOrder();
    }

    /**
     * Возвращает стоимость корзины.
     */
    @Override
    public Double getCount(ShoppingCartDTO shoppingCartDTO) {
        Double count = Double.valueOf(0);
        if (shoppingCartDTO.getOrder() != null ) {
            for (OrderItemDTO orderItemDTO: orderItemService.getOrderItemByOrder(shoppingCartDTO.getOrder()) ) {
                count += orderItemDTO.getCount() * orderItemDTO.getProduct().getPrice();
            }
        }
        return count;
    }

    /**
     * Добавляет товар в корзину.
     */
    @Override
    public void addProduct(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO) {
        orderItemService.addProduct(shoppingCartDTO.getOrder(), productDTO);
    }

    /**
     * Добавляет товар в корзину.
     */
    @Override
    public void addProduct(ShoppingCartDTO shoppingCartDTO, Long productId) {
        addProduct(shoppingCartDTO, productService.get(productId));
    }

    /**
     * Возвращает OrderItem добавленного товара.
     */
    @Override
    public OrderItemDTO addProductAndReturnItem(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO) {
        return orderItemService.addProductAndReturnItem(shoppingCartDTO.getOrder(), productDTO);
    }

    /**
     * Изменяет количество товара в позиции заказа.
     */
    @Override
    public void editCountOrderItem(OrderItemDTO orderItemDTO, Integer count) {
        orderItemService.editCount(orderItemDTO, count);
    }

    /**
     * Изменяет количество товара в позиции заказа.
     */
    @Override
    public void editCountOrderItem(Long orderItemId, Integer count) {
       editCountOrderItem(orderItemService.get(orderItemId), count);
    }

    /**
     * Удаляет позицию заказа из корзины.
     */
    @Override
    public void deleteOrderItem(OrderItemDTO orderItemDTO) {
        orderItemService.delete(orderItemDTO);
    }

    /**
     * Удаляет позицию заказа из корзины по ее идентификатору.
     */
    @Override
    public void deleteOrderItem(Long orderItemId) {
        orderItemService.delete(orderItemId);
    }

    /**
     * Очищает корзину.
     */
    @Override
    public void deleteOrderItems(ShoppingCartDTO shoppingCartDTO) {
        orderItemService.delete(orderItemService.getOrderItemByOrder(shoppingCartDTO.getOrder()));
    }
}
