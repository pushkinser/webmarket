package ru.webmarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.service.impl.ShoppingCartServiceImpl;
import ru.webmarket.service.impl.UserServiceImpl;

import java.util.List;


@RestController
@RequestMapping(value = "/api/bag")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    private UserServiceImpl userService;

    // Получить корзину по id пользователя
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ShoppingCartDTO getShoppingCart(@PathVariable("id") Long id) {
        return userService.getShoppingCart(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ShoppingCartDTO> getAllShoppingCart() {
        return shoppingCartService.getShoppingCarts();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.addShoppingCart(shoppingCartDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.editShoppingCart(shoppingCartDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteShoppingCart(Long id) {
        shoppingCartService.deleteShoppingCart(id);
    }
}