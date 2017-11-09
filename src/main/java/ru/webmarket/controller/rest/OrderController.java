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
import ru.webmarket.model.dto.UserDTO;
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

    private final ShoppingCartServiceImpl shoppingCartService;

    private final OrderServiceImpl orderService;

    private final OrderItemServiceImpl orderItemService;

    @Autowired
    public OrderController(ShoppingCartServiceImpl shoppingCartService, OrderServiceImpl orderService, OrderItemServiceImpl orderItemService) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }

    private ShoppingCartDTO getCurrentShoppingCart() {
        if (SecurityUtils.getCurrentDetails() == null) return null;
        UserDTO userDTO = SecurityUtils.getCurrentDetails();
        if (userDTO != null) {
            return shoppingCartService.getByUserId(userDTO.getId());
        }
        return null;
    }

    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    public void completeOrder (@RequestBody OrderBodyJson orderBodyJson) {

        ShoppingCartDTO shoppingCartDTO = getCurrentShoppingCart();

        OrderDTO order = new OrderDTO();

        if (shoppingCartDTO != null) {
            order.setUser(shoppingCartDTO.getUser());
        }
        order.setAddress(orderBodyJson.getAddress());
        order = orderService.add(order);

        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        if (shoppingCartDTO != null) {
            for (OrderItemDTO orderItemDTO : orderItemService.getOrderItemByOrder(shoppingCartDTO.getOrder())) {
                orderItemDTO.setOrder(order);
                orderItemDTOList.add(orderItemDTO);
            }
        }

        orderItemService.add(orderItemDTOList);

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<OrderBody> getOrders () {


        List<OrderDTO> orderDTOS = orderService.getByUserId(SecurityUtils.getCurrentDetails().getId());
        List<OrderBody> orderBodyResponse = new ArrayList<>();

        for (OrderDTO orderDTO: orderDTOS) {
            if (!orderDTO.getId().equals(getCurrentShoppingCart().getOrder().getId())) {
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