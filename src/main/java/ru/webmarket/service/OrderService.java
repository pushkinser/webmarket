package ru.webmarket.service;

import org.springframework.stereotype.Service;
import ru.webmarket.entity.Order;
import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.entity.dto.ShoppingCartDTO;

import java.util.List;

/**
 * @author Сергей
 */

public interface OrderService {

    void addOrder(OrderDTO orderDTO);

    void setOrder(OrderDTO orderDTO, ShoppingCartDTO shoppingCartDTO);

    List<OrderDTO> getAllOrder();

    void addProduct(OrderDTO orderDTO, ProductDTO productDTO);

    void addProduct(OrderDTO orderDTO, List<ProductDTO> productDTOS);

    OrderDTO getOrder(Long id);

    void editOrder(OrderDTO orderDTO);

    void deleteOrder(Long id);

    List<ProductDTO> getProduct(Long id);

}
