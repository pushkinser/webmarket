package ru.webmarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.webmarket.service.impl.OrderServiceImpl;
import ru.webmarket.service.impl.ShoppingCartServiceImpl;

@RestController
@RequestMapping(value = "/api/order")
@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SELLER"})
public class OrderController {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    public void completeOrder () {


    }
}
