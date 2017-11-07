package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.model.dto.OrderDTO;
import ru.webmarket.model.dto.OrderItemDTO;
import ru.webmarket.model.mapper.OrderMap;
import ru.webmarket.repository.OrderItemRepository;
import ru.webmarket.repository.OrderRepository;
import ru.webmarket.service.OrderItemService;
import ru.webmarket.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderItemServiceImpl orderItemService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderItemServiceImpl orderItemService) {
        this.orderRepository = orderRepository;
        this.orderItemService = orderItemService;
    }


    /**
     * Возвращает заказ по его идентификатору.
     */
    @Override
    public OrderDTO get(Long id) {
        return OrderMap.toDto(orderRepository.findOne(id));
    }

    /**
     * Возвращает стоимость заказа.
     */
    @Override
    public Double getCount(Long id) {
        Double count = Double.valueOf(0);
        if (orderRepository.findOne(id) != null ) {
            for (OrderItemDTO orderItemDTO: orderItemService.getOrderItemByOrder(OrderMap.toDto(orderRepository.findOne(id))) ) {
                count += orderItemDTO.getCount() * orderItemDTO.getProduct().getPrice();
            }
        }
        return count;
    }

    /**
     * Возвращает список заказов пользователя.
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
