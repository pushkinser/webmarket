package ru.webmarket.service;

import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.ProductDTO;

import java.util.List;

/**
 * @author Сергей
 */

public interface OrderService {

    void addOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrders();

    OrderDTO getOrder(Long id);

    void editOrder(OrderDTO orderDTO);

    void addProduct(OrderDTO orderDTO, ProductDTO productDTO, int count);

    // Намного выгоднее делать? void addProducts(OrderDTO, List<ProductDTO>)

    List<ProductDTO> getProducts(OrderDTO orderDTO);

    void deleteOrder(Long id);

}
