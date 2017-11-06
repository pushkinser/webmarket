package ru.webmarket.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.model.entity.Order;
import ru.webmarket.model.entity.OrderItem;
import ru.webmarket.model.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderRepositoryTest extends AppTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldGetAllOrders() {
        Assert.assertNotNull(orderRepository.findAll());
    }

//    @Test
//    public void shouldSaveNewOrderWithOrderItem() {
//
//        // Добавление товара в заказ.
//
//        OrderItem orderItem = new OrderItem();
//        Order order = new Order();
//
//        Product product = productRepository.findOne(1L);
//        orderItem.setProduct(product);
//        orderItem.setCount(80);
//        orderItem.setOrder(order);
//
//        order.setUser(userRepository.findOne(1L));
////        order.setOrderItems(Collections.singletonList(orderItem));
//
////        orderItem.setProduct(product);
////        orderItem.setOrder(order);
//        Assert.assertNotNull(order);
//
////        order.setUser(userRepository.findOne(1L));
////        order.setOrderItems(Collections.singletonList(orderItem));
//
//        Assert.assertNotNull(orderRepository.save(order));
//    }

//    @Test
//    public void shouldSaveNewOrderWithOrderItemThenDelete() {
//
//        // Добавление товара в заказ.
//
//        OrderItem orderItem = new OrderItem();
//        Order order = new Order();
//        Product product = productRepository.findOne(1L);
//        orderItem.setProduct(product);
//        orderItem.setCount(77);
//        orderItem.setOrder(order);
//
//        order.setUser(userRepository.findOne(1L));
////        order.setOrderItems(new ArrayList<>(Collections.singletonList(orderItem)));
//
////        orderItem.setProduct(product);
////        orderItem.setOrder(order);
//        Assert.assertNotNull(order);
//
//        Order newOrder = orderRepository.save(order);
//        Assert.assertNotNull(order.getOrderItems());
//
////        orderItemRepository.delete(newOrder.getOrderItems());
//        orderRepository.delete(order);
//
//    }



    @Test
    public void shouldSaveEmptyOrder() {

        Order order = new Order();
        order.setUser(userRepository.findOne(1L));
        order = orderRepository.save(order);
        Assert.assertNotNull(order);
        order.setAddress("blabla adress");
        Assert.assertNotNull(orderRepository.save(order).getAddress());
    }

}