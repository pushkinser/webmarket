package ru.webmarket.service;

import ru.webmarket.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO get (Long id);

    OrderDTO add (OrderDTO orderDTO);

    List<OrderDTO> getByUserId(Long userId);
}
