package ru.webmarket.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.webmarket.service.impl.OrderServiceImpl;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;
}
