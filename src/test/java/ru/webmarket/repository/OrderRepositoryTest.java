package ru.webmarket.repository;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.webmarket.AppTest;
import ru.webmarket.configuration.Persistence;
import ru.webmarket.entity.Order;
import ru.webmarket.repository.OrderRepository;

public class OrderRepositoryTest extends AppTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void shouldGetOrders () {
        Assert.assertNotNull(orderRepository.findAll());
    }
}
