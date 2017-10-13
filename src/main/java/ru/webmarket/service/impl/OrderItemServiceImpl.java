package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.OrderItem;
import ru.webmarket.entity.converter.OrderConverter;
import ru.webmarket.entity.converter.OrderItemConverter;
import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.OrderItemDTO;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.repository.OrderItemRepository;
import ru.webmarket.service.OrderItemService;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void addOrderItemToOrder(OrderItemDTO orderItemDTO, OrderDTO orderDTO) {
        OrderItem orderItem = OrderItemConverter.dtoToEntity(orderItemDTO);
        orderItem.setOrder(OrderConverter.dtoToEntity(orderDTO));
        if (orderItem != null) orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItemDTO> getOrdersItems() {
        return OrderItemConverter.entityToDto(orderItemRepository.findAll());
    }

    @Override
    public OrderItemDTO getOrderItem(Long id) {
        return OrderItemConverter.entityToDto(orderItemRepository.findOne(id));
    }

    @Override
    public void editOrderItem(OrderItemDTO orderItemDTO) {
        if (orderItemDTO == null) throw new NullPointerException();
        if (orderItemRepository.findOne(orderItemDTO.getId()) != null)
            orderItemRepository.save(OrderItemConverter.dtoToEntity(orderItemDTO));
    }

    @Override
    public void addProduct(OrderItemDTO orderItemDTO, ProductDTO productDTO) {
        orderItemDTO.setProduct(productDTO);
        editOrderItem(orderItemDTO);
    }

    @Override
    public void addProduct(Long orderId, ProductDTO productDTO) {
        OrderItemDTO orderItemDTO = OrderItemConverter.entityToDto(orderItemRepository.findOne(orderId));
        addProduct(orderItemDTO, productDTO);
    }

    @Override
    public ProductDTO getProduct(OrderItemDTO orderItemDTO) {
        return orderItemDTO.getProduct();
    }

    @Override
    public void setCount(OrderItemDTO orderItemDTO, int count) {
        orderItemDTO.setCount(count);
        editOrderItem(orderItemDTO);
    }

    @Override
    public int getCount(OrderItemDTO orderItemDTO) {
        return orderItemDTO.getCount();
    }

    @Override
    public void deleteOrderItem(Long id) {
        if (orderItemRepository.findOne(id) == null) throw new NullPointerException();
        orderItemRepository.delete(id);
    }
}
