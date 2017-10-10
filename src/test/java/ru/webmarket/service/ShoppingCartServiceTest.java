package ru.webmarket.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.service.impl.ShoppingCartServiceImpl;

import java.util.List;

public class ShoppingCartServiceTest extends AppTest {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @Test
    public void ShouldGetAllShoppingCart () {
        List<ShoppingCartDTO> shoppingCartDTOS = shoppingCartService.getShoppingCarts();
        for (ShoppingCartDTO shoppingCartDTO: shoppingCartDTOS) {
            Assert.assertNotNull(shoppingCartDTO);
        }
    }



}
