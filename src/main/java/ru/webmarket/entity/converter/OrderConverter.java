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
        Order order = new Order();

        order.setId(orderDTO.getId());
        order.setProducts(ProductConverter.dtoToEntity((orderDTO.getProducts())));
        order.setTotal(orderDTO.getTotal());

        return order;
    }

    public static OrderDTO entityToDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setProducts(ProductConverter.entityToDto(order.getProducts()));
        orderDTO.setTotal(order.getTotal());

        return orderDTO;
    }

    public static List<Order> dtoToEntity(List<OrderDTO> orderDTOS) {
        List<Order> orders = new ArrayList<>();

        for (OrderDTO orderDTO : orderDTOS) {
            orders.add(OrderConverter.dtoToEntity(orderDTO));
        }

        return orders;
    }

    public static List<OrderDTO> entityToDto(List<Order> orders) {
        List<OrderDTO> orderDTOS = new ArrayList<>();

        for (Order order : orders) {
            orderDTOS.add(OrderConverter.entityToDto(order));
        }

        return orderDTOS;
    }
}
