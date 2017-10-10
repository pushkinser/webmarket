package ru.webmarket.service;

import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.OrderItemDTO;
import ru.webmarket.entity.dto.ProductDTO;

import java.util.List;

public interface OrderItemService {

    void addOrderItem(OrderItemDTO orderItemDTO);

    List<OrderItemDTO> getOrdersItems();

    OrderItemDTO getOrderItem(Long id);

    void editOrderItem(OrderItemDTO orderItemDTO);

    void addProduct(OrderItemDTO orderItemDTO, ProductDTO productDTO);

    void addProduct(Long orderId, ProductDTO productDTO);

    ProductDTO getProduct(OrderItemDTO orderItemDTO);

    void setCount(OrderItemDTO orderItemDTO, int count);

    int getCount(OrderItemDTO orderItemDTO);

    void deleteOrderItem(Long id);
}
