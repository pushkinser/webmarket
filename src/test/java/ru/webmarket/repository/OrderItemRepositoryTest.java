package ru.webmarket.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.model.entity.Order;
import ru.webmarket.model.entity.OrderItem;

public class OrderItemRepositoryTest extends AppTest {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void shouldGetAllOrderItems() {
        Assert.assertNotNull(orderItemRepository.findAll());
    }

    @Test
    public void shouldSaveOrderItemWithProduct() {
        OrderItem orderItem = new OrderItem();

        orderItem.setProduct(productRepository.findOne(1L));
        orderItem.setOrder(orderRepository.findOne(1L));
        Assert.assertNotNull(orderItem);
        OrderItem newOrderItem = orderItemRepository.save(orderItem);

        Assert.assertNotNull(newOrderItem);
    }
}
