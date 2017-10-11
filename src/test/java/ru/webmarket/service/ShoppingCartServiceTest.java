package ru.webmarket.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.entity.dto.UserDTO;
import ru.webmarket.service.impl.ShoppingCartServiceImpl;
import ru.webmarket.service.impl.UserServiceImpl;

import java.util.List;

public class ShoppingCartServiceTest extends AppTest {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;
    @Autowired
    private UserServiceImpl userService;

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


}
