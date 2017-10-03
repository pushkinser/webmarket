package ru.webmarket.repository;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.webmarket.configuration.Persistence;
import ru.webmarket.entity.Order;
import ru.webmarket.repository.OrderRepository;

public class OrderRepositoryTest {

    private static OrderRepository orderRepository;

    @BeforeClass
    public static void setup () {
        BasicConfigurator.configure();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Persistence.class);
        orderRepository = ctx.getBean(OrderRepository.class);
    }

    @Test
    public void shouldGetOrders () {
        Iterable<Order> allOrder = orderRepository.findAll();
        for (Order order: allOrder) {
            System.out.println(order);
        }
        Assert.assertNotNull(allOrder);
        Assert.assertTrue(allOrder.iterator().hasNext());

    }
}
