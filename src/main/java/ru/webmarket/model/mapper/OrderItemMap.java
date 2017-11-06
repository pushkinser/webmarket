package ru.webmarket.model.mapper;

import ru.webmarket.model.dto.OrderItemDTO;
import ru.webmarket.model.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemMap {

    public static OrderItem toEntity(OrderItemDTO orderItemDTO) {
        if (orderItemDTO == null) return null;

        OrderItem orderItem = new OrderItem();

        orderItem.setId(orderItemDTO.getId());
        orderItem.setOrder(OrderMap.toEntity(orderItemDTO.getOrder()));
        orderItem.setProduct(ProductMap.toEntity(orderItemDTO.getProduct()));
        orderItem.setCount(orderItemDTO.getCount());


        return orderItem;
    }

//    public static OrderItem toEntity(OrderItemDTO orderItemDTO, OrderDTO orderDTO) {
//        if (orderItemDTO == null) return null;
//
//        OrderItem orderItem = new OrderItem();
//
//        orderItem.setId(orderItemDTO.getId());
//        orderItem.setProduct(ProductMap.toEntity(orderItemDTO.getProduct()));
//        orderItem.setOrder(OrderMap.toEntity(orderDTO));
//        orderItem.setCount(orderItemDTO.getCount());
//
//        return orderItem;
//    }

    public static OrderItemDTO toDto(OrderItem orderItem) {
        if (orderItem == null) return null;

        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setProduct(ProductMap.toDto(orderItem.getProduct()));
        orderItemDTO.setOrder(OrderMap.toDto(orderItem.getOrder()));
        orderItemDTO.setCount(orderItem.getCount());

        return orderItemDTO;
    }

    public static List<OrderItem> toEntity(List<OrderItemDTO> orderItemDTOS) {
        if (orderItemDTOS == null) return null;
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            if (orderItemDTO == null) continue;
            orderItems.add(toEntity(orderItemDTO));
        }

        return orderItems;
    }

//    public static List<OrderItem> toEntity(List<OrderItemDTO> orderItemDTOS, OrderDTO orderDTO) {
//        if (orderItemDTOS == null) return null;
//        List<OrderItem> orderItems = new ArrayList<>();
//
//        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
//            if (orderItemDTO == null) continue;
//            orderItems.add(toEntity(orderItemDTO, orderDTO));
//        }
//
//        return orderItems;
//    }

    public static List<OrderItemDTO> toDto(List<OrderItem> orderItems) {
        if (orderItems == null) return null;
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            if (orderItem == null) continue;
            orderItemDTOS.add(toDto(orderItem));
        }

        return orderItemDTOS;
    }

}