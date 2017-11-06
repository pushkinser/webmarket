package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.model.dto.OrderDTO;
import ru.webmarket.model.dto.OrderItemDTO;
import ru.webmarket.model.dto.ProductDTO;
import ru.webmarket.model.entity.OrderItem;
import ru.webmarket.model.mapper.OrderItemMap;
import ru.webmarket.model.mapper.ProductMap;
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

    /**
     * Возвращает сохраненный список позиций заказа.
     */
    @Override
    public List<OrderItemDTO> add(List<OrderItemDTO> orderItemDTOLists) {
        return OrderItemMap.toDto(orderItemRepository.save(OrderItemMap.toEntity(orderItemDTOLists)));
    }

    /**
     * Возвращает позиии заказа из заказа.
     */
    @Override
    public List<OrderItemDTO> getOrderItemByOrder(OrderDTO orderDTO) {
        if (orderDTO == null) return null;
        return OrderItemMap.toDto(orderItemRepository.findOrderItemsByOrderId(orderDTO.getId()));
    }

    /**
     * Возвращает товар из сохраненного пункта заказа.
     */
    @Override
    public ProductDTO addProduct(OrderDTO orderDTO, ProductDTO productDTO) {
        return addProduct(orderDTO, productDTO, 1);
    }

    /**
     * Возвращает товар из сохраненного пункта заказа.
     */
    @Override
    public ProductDTO addProduct(OrderDTO orderDTO, ProductDTO productDTO, Integer count) {
        if ((orderDTO == null) || (productDTO == null)) return null;
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setOrder(orderDTO);
        orderItemDTO.setProduct(productDTO);
        orderItemDTO.setCount(count);

        return ProductMap.toDto(orderItemRepository.save(OrderItemMap.toEntity(orderItemDTO)).getProduct());
    }

    /**
     * Возвращает добавленную позицию заказа.
     */
    @Override
    public OrderItemDTO addProductAndReturnItem(OrderDTO orderDTO, ProductDTO productDTO) {
        if ((orderDTO == null) || (productDTO == null)) return null;
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setOrder(orderDTO);
        orderItemDTO.setProduct(productDTO);
        orderItemDTO.setCount(1);

        return OrderItemMap.toDto(orderItemRepository.save(OrderItemMap.toEntity(orderItemDTO)));
    }

    /**
     * Удаляет товар(пункт заказа) из заказа.
     */
    @Override
    public void delete(OrderItemDTO orderItemDTO) {
        if (orderItemDTO != null) orderItemRepository.delete(OrderItemMap.toEntity(orderItemDTO));
    }

    /**
     * Удаляет список товаров(пункты заказа) из заказа.
     */
    @Override
    public void delete(List<OrderItemDTO> orderItemDTOLists) {
        if (orderItemDTOLists != null) orderItemRepository.delete(OrderItemMap.toEntity(orderItemDTOLists));
    }

    /**
     * Очищает список заказа.
     */
    @Override
    public void delete(OrderDTO orderDTO) {
        List<OrderItemDTO> orderItemDTOList = getOrderItemByOrder(orderDTO);
        if (orderItemDTOList!= null) delete(orderItemDTOList);
    }

    /**
     * Удаляет позицию заказа по идентификатору.
     */
    @Override
    public void delete(Long orderItemId) {
        orderItemRepository.delete(orderItemId);
    }

    /**
     * Изменяет количество товара в пункте заказа.
     */
    @Override
    public void editCount(OrderItemDTO orderItemDTO, Integer count) {
        if (orderItemDTO != null) {
            orderItemDTO.setCount(count);
            orderItemRepository.save(OrderItemMap.toEntity(orderItemDTO));
        }
    }

    /**
     * Возвращает позицию заказа по идентификатору.
     */
    @Override
    public OrderItemDTO get(Long id) {
        return OrderItemMap.toDto(orderItemRepository.findOne(id));
    }
}
