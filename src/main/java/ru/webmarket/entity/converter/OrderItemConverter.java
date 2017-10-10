package ru.webmarket.entity.converter;

import ru.webmarket.entity.OrderItem;
import ru.webmarket.entity.dto.OrderItemDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderItemConverter {

    public static OrderItem dtoToEntity(OrderItemDTO orderItemDTO) {
        if (orderItemDTO == null) return null;

        OrderItem orderItem = new OrderItem();

        orderItem.setId(orderItemDTO.getId());
        orderItem.setProduct(ProductConverter.dtoToEntity(orderItemDTO.getProductDTO()));
        orderItem.setOrder(OrderConverter.dtoToEntity(orderItemDTO.getOrderDTO()));
        orderItem.setCount(orderItemDTO.getCount());

        return orderItem;
    }

    public static OrderItemDTO entityToDto(OrderItem orderItem) {
        if (orderItem == null) return null;

        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setProductId(orderItem.getProduct().getId());
        orderItemDTO.setOrderId(orderItemDTO.getOrderId());
        orderItemDTO.setProductDTO(ProductConverter.entityToDto(orderItem.getProduct()));
//        orderItemDTO.setOrderDTO(OrderConverter.entityToDto(orderItem.getOrder()));
        orderItemDTO.setCount(orderItem.getCount());

        return orderItemDTO;
    }

    public static List<OrderItem> dtoToEntity(List<OrderItemDTO> orderItemDTOS) {
        if (orderItemDTOS == null) return null;
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            if (orderItemDTO == null) continue;
            orderItems.add(OrderItemConverter.dtoToEntity(orderItemDTO));
        }

        return orderItems;
    }

    public static List<OrderItemDTO> entityToDto(List<OrderItem> orderItems) {
        if (orderItems == null) return null;
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            if (orderItem == null) continue;
            orderItemDTOS.add(OrderItemConverter.entityToDto(orderItem));
        }

        return orderItemDTOS;
    }

}
