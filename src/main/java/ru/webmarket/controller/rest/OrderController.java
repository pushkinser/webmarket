package ru.webmarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.webmarket.controller.rest.request.OrderBodyJson;
import ru.webmarket.model.dto.OrderDTO;
import ru.webmarket.model.dto.OrderItemDTO;
import ru.webmarket.model.dto.ShoppingCartDTO;
import ru.webmarket.security.SecurityUtils;
import ru.webmarket.service.OrderItemService;
import ru.webmarket.service.impl.OrderItemServiceImpl;
import ru.webmarket.service.impl.OrderServiceImpl;
import ru.webmarket.service.impl.ShoppingCartServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/order")
@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SELLER"})
public class OrderController {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderItemServiceImpl orderItemService;

    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    public void completeOrder (@RequestBody OrderBodyJson orderBodyJson) {

        ShoppingCartDTO shoppingCartDTO = shoppingCartService.getByUserId(SecurityUtils.getCurrentDetails().getId());

        OrderDTO order = new OrderDTO();

        order.setUser(shoppingCartDTO.getUser());
        order.setAddress(orderBodyJson.getAddress());
        order = orderService.add(order);

        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        for (OrderItemDTO orderItemDTO : orderItemService.getOrderItemByOrder(shoppingCartDTO.getOrder())) {
            orderItemDTO.setOrder(order);
            orderItemDTOList.add(orderItemDTO);
        }

        orderItemService.add(orderItemDTOList);

    }
}