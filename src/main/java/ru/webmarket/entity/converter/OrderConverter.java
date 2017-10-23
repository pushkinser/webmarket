package ru.webmarket.entity.converter;

import ru.webmarket.entity.Order;
import ru.webmarket.entity.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Сергей
 */
public class OrderConverter {
    public static Order dtoToEntity(OrderDTO orderDTO) {
        if (orderDTO == null) return null;
        Order order = new Order();

        order.setId(orderDTO.getId());
        order.setOrderItems(OrderItemConverter.dtoToEntity((orderDTO.getOrderItems())));
        order.setAddress(orderDTO.getAddress());

        return order;
    }

    public static OrderDTO entityToDto(Order order) {
        if (order == null) return null;
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setOrderItems(OrderItemConverter.entityToDto(order.getOrderItems()));
        orderDTO.setAddress(order.getAddress());

        return orderDTO;
    }

    public static List<Order> dtoToEntity(List<OrderDTO> orderDTOS) {
        if ( orderDTOS == null) return null;
        List<Order> orders = new ArrayList<>();

        for (OrderDTO orderDTO : orderDTOS) {
            if (orderDTO == null) continue;
            orders.add(OrderConverter.dtoToEntity(orderDTO));
        }

        return orders;
    }

    public static List<OrderDTO> entityToDto(List<Order> orders) {
        if ( orders == null) return null;
        List<OrderDTO> orderDTOS = new ArrayList<>();

        for (Order order : orders) {
            if (order == null) continue;
            orderDTOS.add(OrderConverter.entityToDto(order));
        }

        return orderDTOS;
    }
}
