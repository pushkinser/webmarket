package ru.webmarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.webmarket.controller.rest.requestBody.OrderItemBodyJson;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.security.SecurityUtils;
import ru.webmarket.service.impl.ShoppingCartServiceImpl;


@RestController
@RequestMapping(value = "/api/shoppingcart")
@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    private ShoppingCartDTO getCurrentShoppingCart() {
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

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public Double getTotalsShoppingCart() {
        return shoppingCartService.getTotal(getCurrentShoppingCart());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.addShoppingCart(shoppingCartDTO);
    }

//    @RequestMapping(value = "/", method = RequestMethod.PUT)
//    public void updateShoppingCart(ShoppingCartDTO shoppingCartDTO) {
//        shoppingCartService.editShoppingCart(shoppingCartDTO);
//    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
    public void addProduct(@RequestBody OrderItemBodyJson a) {
        shoppingCartService.addProduct(getCurrentShoppingCart(), a.getId(), a.getCount());
    }

    @RequestMapping(value = "/count", method = RequestMethod.PUT, consumes = "application/json")
    public void editProductCount(@RequestBody OrderItemBodyJson productBody) {
        shoppingCartService.editProductCount(productBody.getId(), productBody.getCount());
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteProduct(@RequestBody OrderItemBodyJson productBody) {
        if (productBody.getFlag()) shoppingCartService.deleteProducts(getCurrentShoppingCart());
        else shoppingCartService.deleteProduct(getCurrentShoppingCart(), productBody.getId());
    }

//    // Удаление всех товаров из корзины
//    @RequestMapping(value = "/", method = RequestMethod.DELETE, consumes = "application/json")
//    public void deleteProducts(@RequestBody FlagBodyJson flag) {
//        if (flag.getFlag()) shoppingCartService.deleteProducts(getCurrentShoppingCart());
//    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteShoppingCart(Long id) {
        shoppingCartService.deleteShoppingCart(id);
    }
}