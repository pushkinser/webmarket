package ru.webmarket.controller.rest;

import lombok.Getter;
import lombok.Setter;
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

    private ShoppingCartDTO getCurrentShoppingCart() {
        return shoppingCartService.getByUserId(SecurityUtils.getCurrentDetails().getId());
    }

    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    public void completeOrder (@RequestBody OrderBodyJson orderBodyJson) {

        ShoppingCartDTO shoppingCartDTO = getCurrentShoppingCart();

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

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<OrderBody> getOrders () {

        List<OrderBody> orderBodyResponse = new ArrayList<>();
        List<OrderDTO> orderDTOS = orderService.getByUserId(SecurityUtils.getCurrentDetails().getId());

        for (OrderDTO orderDTO: orderDTOS) {
            if (orderDTO.getId() != getCurrentShoppingCart().getOrder().getId()) {
                OrderBody orderBodyItem = new OrderBody();
                orderBodyItem.setId(orderDTO.getId());
                orderBodyItem.setAddress(orderDTO.getAddress());
                orderBodyItem.setOrderItem(orderItemService.getOrderItemByOrder(orderDTO));
                orderBodyItem.setPrise(orderService.getCount(orderDTO.getId()));

                orderBodyResponse.add(orderBodyItem);
            }

        }

        return orderBodyResponse;

    }

    @Getter
    @Setter
    private class OrderBody {
        Long id;
        List<OrderItemDTO> orderItem;
        String address;
        Double prise;
    }
}