package ru.webmarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.security.SecurityUtils;
import ru.webmarket.service.impl.ShoppingCartServiceImpl;
import ru.webmarket.service.impl.UserServiceImpl;


@RestController
@RequestMapping(value = "/api/shoppingcart")
@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    private UserServiceImpl userService;

    private ShoppingCartDTO getCurrentShoppingCart () {
        return shoppingCartService.getShoppingCartByUserId(SecurityUtils.getCurrentDetails().getId());
    }

    // Получить корзину по id корзины
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ShoppingCartDTO getShoppingCartById(@PathVariable("id") Long id) {
        return shoppingCartService.getShoppingCart(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ShoppingCartDTO getShoppingCart() {
          return getCurrentShoppingCart();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.addShoppingCart(shoppingCartDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.editShoppingCart(shoppingCartDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void addProduct(@PathVariable("id") Long id) {
        shoppingCartService.addProduct(getCurrentShoppingCart(), id);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteShoppingCart(Long id) {
        shoppingCartService.deleteShoppingCart(id);
    }
}