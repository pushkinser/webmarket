package ru.webmarket.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;

public class OrderItemRepositoryTest extends AppTest {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    public void shouldGetOrderItems() {
        Assert.assertNotNull(orderItemRepository.findAll());
    }

}