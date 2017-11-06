package ru.webmarket.service;

import ru.webmarket.model.dto.OrderDTO;
import ru.webmarket.model.dto.OrderItemDTO;
import ru.webmarket.model.dto.ProductDTO;
import ru.webmarket.model.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItemDTO> add ( List<OrderItemDTO> orderItemDTOLists);

    List<OrderItemDTO> getOrderItemByOrder(OrderDTO orderDTO);

    ProductDTO addProduct(OrderDTO orderDTO, ProductDTO productDTO);

    OrderItemDTO addProductAndReturnItem (OrderDTO orderDTO, ProductDTO productDTO);

    ProductDTO addProduct(OrderDTO orderDTO, ProductDTO productDTO, Integer count);

    void delete(OrderItemDTO orderItemDTO);

    void delete(List<OrderItemDTO> orderItemDTOLists);

    void delete(OrderDTO orderDTO);

    void delete(Long orderItemId);

    void editCount(OrderItemDTO orderItemDTO, Integer count);

    OrderItemDTO get (Long id);

}
