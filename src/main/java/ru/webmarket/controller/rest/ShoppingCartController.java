package ru.webmarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.webmarket.controller.rest.request.OrderItemBodyJson;
import ru.webmarket.model.dto.OrderItemDTO;
import ru.webmarket.model.dto.ShoppingCartDTO;
import ru.webmarket.security.SecurityUtils;
import ru.webmarket.service.OrderItemService;
import ru.webmarket.service.impl.ShoppingCartServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/shoppingcart")
@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SELLER"})
public class ShoppingCartController {

    private final ShoppingCartServiceImpl shoppingCartService;

    private final OrderItemService orderItemService;

    @Autowired
    public ShoppingCartController(ShoppingCartServiceImpl shoppingCartService, OrderItemService orderItemService) {
        this.shoppingCartService = shoppingCartService;
        this.orderItemService = orderItemService;
    }

    private ShoppingCartDTO getCurrentShoppingCart() {
        return shoppingCartService.getByUserId(SecurityUtils.getCurrentDetails().getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ShoppingCartDTO getShoppingCartById(@PathVariable("id") Long id) {
        return shoppingCartService.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<OrderItemDTO> getShoppingCart() {
        return orderItemService.getOrderItemByOrder(getCurrentShoppingCart().getOrder());
    }

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public Double getTotalsShoppingCart() {
        return shoppingCartService.getCount(getCurrentShoppingCart());
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
    public void addProduct(@RequestBody OrderItemBodyJson a) {
        shoppingCartService.addProduct(getCurrentShoppingCart(), a.getId());
    }

    @RequestMapping(value = "/count", method = RequestMethod.PUT, consumes = "application/json")
    public void editProductCount(@RequestBody OrderItemBodyJson productBody) {
        shoppingCartService.editCountOrderItem(productBody.getId(), productBody.getCount());
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteProduct(@RequestBody OrderItemBodyJson orderItemBodyJson) {
        if (orderItemBodyJson.getFlag()) shoppingCartService.deleteOrderItems(getCurrentShoppingCart());
        else shoppingCartService.deleteOrderItem(orderItemBodyJson.getId());
    }

    @RequestMapping(value = "/isempty", method = RequestMethod.GET)
    public Boolean isEmpty() {
        return shoppingCartService.isEmpty(getCurrentShoppingCart());
    }

}