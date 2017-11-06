package ru.webmarket.model.mapper;

import ru.webmarket.model.dto.OrderDTO;
import ru.webmarket.model.entity.Order;
import ru.webmarket.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OrderMap {

    public static Order toEntity(OrderDTO orderDTO) {
        if (orderDTO == null) return null;
        Order order = new Order();

        order.setId(orderDTO.getId());
//        order.setOrderItems(OrderItemMap.toEntity((orderDTO.getOrderItems())));
        order.setAddress(orderDTO.getAddress());
        order.setUser(UserMap.toEntity(orderDTO.getUser()));

        return order;
    }

    public static OrderDTO toDto(Order order) {
        if (order == null) return null;
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
//        orderDTO.setOrderItems(OrderItemMap.toDto(order.getOrderItems()));
        orderDTO.setAddress(order.getAddress());
        orderDTO.setUser(UserMap.toDto(order.getUser()));

        return orderDTO;
    }

    public static List<Order> toEntity(List<OrderDTO> orderDTOS) {
        if ( orderDTOS == null) return null;
        List<Order> orders = new ArrayList<>();

        for (OrderDTO orderDTO : orderDTOS) {
            if (orderDTO == null) continue;
            orders.add(toEntity(orderDTO));
        }

        return orders;
    }

    public static List<OrderDTO> toDto(List<Order> orders) {
        if ( orders == null) return null;
        List<OrderDTO> orderDTOS = new ArrayList<>();

        for (Order order : orders) {
            if (order == null) continue;
            orderDTOS.add(toDto(order));
        }

        return orderDTOS;
    }
}
