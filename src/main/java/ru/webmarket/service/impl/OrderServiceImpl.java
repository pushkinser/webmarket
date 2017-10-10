package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.OrderItem;
import ru.webmarket.entity.converter.OrderConverter;
import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.OrderItemDTO;
import ru.webmarket.entity.dto.ProductDTO;
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

    @Override
    public void addOrder(OrderDTO orderDTO) {
        if (orderDTO == null) throw new NullPointerException();
        orderRepository.save(OrderConverter.dtoToEntity(orderDTO));
    }

    @Override
    public List<OrderDTO> getOrders() {
        return OrderConverter.entityToDto(orderRepository.findAll());
    }

    @Override
    public OrderDTO getOrder(Long id) {
        return OrderConverter.entityToDto(orderRepository.findOne(id));
    }

    @Override
    public void editOrder(OrderDTO orderDTO) {
        if (orderDTO == null) throw new NullPointerException();
        if (orderRepository.findOne(orderDTO.getId()) != null)
            orderRepository.save(OrderConverter.dtoToEntity(orderDTO));
    }

    @Override
    public void addProduct(OrderDTO orderDTO, ProductDTO productDTO, int count) {
        if ((orderDTO == null) || (productDTO == null)) throw new NullPointerException();
        OrderItemDTO orderItemDTO = new OrderItemDTO(productDTO, count);
        orderDTO.addOrderItemDTO(orderItemDTO);
        editOrder(orderDTO);
    }

    @Override
    public List<ProductDTO> getProducts(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }


//
//    @Override
//    public void editOrder(OrderDTO orderDTO) {
//
//    }
//
//    @Override
//    public void addProduct(OrderDTO orderDTO, ProductDTO productDTO) {
//
//    }
//
//    @Override
//    public void addProducts(OrderDTO orderDTO, List<ProductDTO> productDTOS) {
//        if ((orderDTO == null) || (productDTOS == null)) throw new NullPointerException();
//        orderDTO.addProducts(productDTOS);
//        editOrder(orderDTO);
//    }
//
//    @Override
//    public List<ProductDTO> getProducts(OrderDTO orderDTO) {
//
//    }
//
//    @Override
//    public void deleteOrder(Long id) {
//        if (orderRepository.findOne(id) == null) throw new NullPointerException();
//        orderRepository.delete(id);
//    }
}
