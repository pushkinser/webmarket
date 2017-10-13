package ru.webmarket.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.entity.OrderItem;
import ru.webmarket.entity.Product;
import ru.webmarket.entity.dto.*;
import ru.webmarket.service.impl.ShoppingCartServiceImpl;
import ru.webmarket.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Random;

public class ShoppingCartServiceTest extends AppTest {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @Test
    public void ShouldGetAllShoppingCart() {
        List<ShoppingCartDTO> shoppingCartDTOS = shoppingCartService.getShoppingCarts();
        for (ShoppingCartDTO shoppingCartDTO : shoppingCartDTOS) {
            Assert.assertNotNull(shoppingCartDTO);
        }
    }

    @Test
    public void ShouldGetShoppingCartByUserId() {
        Assert.assertNotNull(userService.findByUserName("test"));
        UserDTO userDTO = userService.findByUserName("test");
        Assert.assertNotNull(shoppingCartService.getShoppingCartByUserId(userDTO.getId()));
        System.out.println(shoppingCartService.getShoppingCartByUserId(userDTO.getId()));
    }

    final Random random = new Random();

    @Test
    public void ShouldEditShoppingCart() {
        int r =  random.nextInt();
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getShoppingCartByUserId(userService.findByUserName("test").getId());
        OrderDTO orderDTO = shoppingCartDTO.getOrder();
        OrderDTO orderDTO2 = orderDTO;
        Assert.assertEquals(orderDTO, orderDTO2);
        System.out.println(orderDTO);

        ProductDTO productDTO = productService.getProduct(1L);
        OrderItemDTO orderItemDTO = new OrderItemDTO(orderDTO, productDTO, 1);
//        orderItemService.addOrderItem(orderItemDTO);

        orderDTO.addOrderItemDTO(orderItemDTO);
        shoppingCartDTO.setOrder(orderDTO);
        System.out.println(orderDTO);

        shoppingCartService.editShoppingCart(shoppingCartDTO);
        Assert.assertNotEquals(orderDTO, orderDTO2);
    }

    @Test
    public void ShouldAddProductAndFindProduct() {
        Assert.assertNotNull(userService.findByUserName("test"));
        UserDTO userDTO = userService.findByUserName("test");
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getShoppingCartByUserId(userDTO.getId());
        OrderDTO orderDTO = orderService.getOrder(shoppingCartDTO.getOrder().getId());
        ProductDTO productDTO = productService.getProduct(36L);
//        OrderItemDTO orderItemDTO = new OrderItemDTO(orderDTO, productDTO, 1);

        shoppingCartService.addProduct(shoppingCartDTO, productDTO.getId(), 101);
//        orderService.addOrderItem(orderDTO, orderItemDTO);
//        orderItemService.addOrderItemToOrder(orderItemDTO, orderDTO);

//        shoppingCartService.addProduct(shoppingCartDTO, productDTO);

//        shoppingCartDTO = shoppingCartService.getShoppingCartByUserId(userDTO.getId());
//        List<ProductDTO> productDTOS = shoppingCartService.getProducts(shoppingCartDTO);
        Assert.assertNotNull(shoppingCartService.getShoppingCartByUserId(userDTO.getId()).getOrder().getOrderItems().contains(productDTO));
//        Assert.assertNotNull(shoppingCartDTO.getUserId());
        System.out.println( shoppingCartService.getShoppingCartByUserId(userDTO.getId()));
    }

    @Test
    public void ShouldDeleteProduct () {
        Assert.assertNotNull(userService.findByUserName("test"));
        UserDTO userDTO = userService.findByUserName("test");
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getShoppingCartByUserId(userDTO.getId());
        ProductDTO productDTO = productService.getProduct(36L);
        shoppingCartService.addProduct(shoppingCartDTO, productDTO.getId(), 77);
        Assert.assertNotNull(shoppingCartService.getShoppingCartByUserId(userDTO.getId()).getOrder().getOrderItems().contains(productDTO));
        shoppingCartService.deleteProduct(shoppingCartService.getShoppingCartByUserId(userDTO.getId()), productDTO);
        Assert.assertFalse(shoppingCartService.getShoppingCartByUserId(userDTO.getId()).getOrder().getOrderItems().contains(productDTO));
    }

}