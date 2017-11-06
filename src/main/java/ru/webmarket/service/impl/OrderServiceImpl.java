package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.model.dto.OrderDTO;
import ru.webmarket.model.mapper.OrderMap;
import ru.webmarket.repository.OrderRepository;
import ru.webmarket.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Возвращает заказ по его идентификатору.
     */
    @Override
    public OrderDTO get(Long id) {
        return OrderMap.toDto(orderRepository.findOne(id));
    }

    /**
     * Возвращает список заказов пользователя.
     *
     * TODO: не возвращать заказ-корзину, сейчас возвращаюся все заказы.
     */
    @Override
    public List<OrderDTO> getByUserId(Long userId) {
        return OrderMap.toDto(orderRepository.findByUserId(userId));
    }

    /**
     * Возвращает новый созданный заказ.
     */
    @Override
    public OrderDTO add(OrderDTO orderDTO) {
        if (orderDTO == null) return null;
        return OrderMap.toDto(orderRepository.save(OrderMap.toEntity(orderDTO)));
    }
}
