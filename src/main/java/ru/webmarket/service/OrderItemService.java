package ru.webmarket.service;

import ru.webmarket.model.dto.OrderDTO;
import ru.webmarket.model.dto.OrderItemDTO;
import ru.webmarket.model.dto.ProductDTO;

import java.util.List;

public interface OrderItemService {

    List<OrderItemDTO> add(List<OrderItemDTO> orderItemDTOLists);

    List<OrderItemDTO> getOrderItemByOrder(OrderDTO orderDTO);

    void addProduct(OrderDTO orderDTO, ProductDTO productDTO);

    OrderItemDTO addProductAndReturnItem(OrderDTO orderDTO, ProductDTO productDTO);

    void addProduct(OrderDTO orderDTO, ProductDTO productDTO, Integer count);

    void delete(OrderItemDTO orderItemDTO);

    void delete(List<OrderItemDTO> orderItemDTOLists);

    void delete(Long orderItemId);

    void editCount(OrderItemDTO orderItemDTO, Integer count);

    OrderItemDTO get(Long id);

}
