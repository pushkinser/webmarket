package ru.webmarket.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.model.dto.OrderDTO;
import ru.webmarket.model.dto.OrderItemDTO;
import ru.webmarket.model.dto.ShoppingCartDTO;
import ru.webmarket.model.dto.UserDTO;
import ru.webmarket.service.impl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServiceTest extends AppTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private OrderItemServiceImpl orderItemService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    private Random random = new Random();

    /**
     * Регистрирует нового пользователя с ролью, пустой корзиной.
     * <p>
     * Работает 3.11.17 16.30
     */
    @Test
    public void shouldRegisterUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("test" + random.nextInt());
        userDTO.setPassword(" " + random.nextInt());
//        userDTO.setRoles(Collections.singletonList(roleService.get("CUSTOMER")));

        UserDTO newUserDTO = userService.register(userDTO);

        Assert.assertNotNull(newUserDTO);
        Assert.assertNotNull(newUserDTO.getRoles());
        Assert.assertNotNull(newUserDTO.getUserName());
        Assert.assertNotNull(newUserDTO.getPassword());

        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getByUserId(newUserDTO.getId());

        Assert.assertNotNull(shoppingCartDTO);
        Assert.assertNotNull(shoppingCartDTO.getOrder());
        Assert.assertNotNull(shoppingCartDTO.getOrder().getUser());
        Assert.assertNotNull(shoppingCartDTO.getUser());

    }

    /**
     * Высчитывает стоимость корзины.
     * <p>
     * Работает 3.11.17 16.30
     */
    @Test
    public void shouldGetShoppingCartsCost() {
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getByUserId(1L);

        Assert.assertNotNull(shoppingCartDTO);

        Double count = shoppingCartService.getCount(shoppingCartDTO);
        Assert.assertNotNull(count);

        System.out.println(count);
    }

    /**
     * Добавляет товар в корзину по его иедентификатору.
     * <p>
     * Работает 3.11.17 17.00
     */
    @Test
    public void shouldAddProductToShoppingCart() {
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getByUserId(1L);

        shoppingCartService.addProduct(shoppingCartDTO, productService.get(1L));

        List<OrderItemDTO> orderItemDTOList = orderItemService.getOrderItemByOrder(shoppingCartDTO.getOrder());

        Assert.assertNotNull(orderItemDTOList);
        System.out.println(orderItemDTOList);
    }

    /**
     * Удаляет позицию из заказа корзины.
     *
     * Работает 3.11.17 17.10
     *
     * Закомментировано по причине хардкода OrderItem.
     */
//    @Test
//    public void shouldDeleteOrderItemByShoppingCart() {
//        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getByUserId(1L);
//
//        shoppingCartService.addProduct(shoppingCartDTO, productService.get(1L));
//
//        List<OrderItemDTO> orderItemDTOList = orderItemService.getOrderItemByOrder(shoppingCartDTO.getOrder());
//
//        // захардкорженный id OrderItem
//        shoppingCartService.deleteOrderItem(493L);
//
//        Assert.assertNotNull(orderItemDTOList);
//        Assert.assertNotEquals(orderItemDTOList, orderItemService.getOrderItemByOrder(shoppingCartDTO.getOrder()));
//        System.out.println(orderItemDTOList);
//    }

    /**
     * Очищает корзину от заказов.
     * <p>
     * Работает 3.11.17 17.20
     */
    @Test
    public void shouldDeleteOrderItemByShoppingCart() {
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getByUserId(1L);

        shoppingCartService.deleteOrderItems(shoppingCartDTO);

    }

    /**
     * Изменяет количество товара в позиции заказа.
     * <p>
     * Работает 3.11.17 17.40
     */
    @Test
    public void shouldAddProductAndEditCount() {
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getByUserId(1L);

        OrderItemDTO orderItemDTO = shoppingCartService.addProductAndReturnItem(shoppingCartDTO, productService.get(1L));

        shoppingCartService.editCountOrderItem(orderItemDTO, 101);

        List<OrderItemDTO> orderItemDTOList = orderItemService.getOrderItemByOrder(shoppingCartDTO.getOrder());

        Assert.assertNotNull(orderItemDTOList);

//        Assert.assertNotEquals(orderItemService.get(orderItemDTO.getId()), orderItemDTO);
    }

    /**
     * Оформляет заказ, перенося корзину в новый order и очищает корзину.
     * <p>
     * Работает 3.11.17 18.00
     */
    @Test
    public void shouldCreateOrderWithAddressFromShoppingCart() {
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getByUserId(1L);

        OrderDTO order = new OrderDTO();

        order.setUser(shoppingCartDTO.getUser());
        order.setAddress("super Address");
        order = orderService.add(order);

        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        for (OrderItemDTO orderItemDTO : orderItemService.getOrderItemByOrder(shoppingCartDTO.getOrder())) {
            orderItemDTO.setOrder(order);
            orderItemDTOList.add(orderItemDTO);
        }

        orderItemService.add(orderItemDTOList);

        Assert.assertNotNull(orderItemService.getOrderItemByOrder(order));

    }

}
