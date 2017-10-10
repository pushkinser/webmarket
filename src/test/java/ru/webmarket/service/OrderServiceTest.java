package ru.webmarket.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.OrderItemDTO;
import ru.webmarket.service.impl.OrderServiceImpl;

import java.util.List;

public class OrderServiceTest extends AppTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void ShouldGetOrders() {
        Assert.assertNotNull(orderService.getOrders());
        List<OrderDTO> orderDTOS = orderService.getOrders();
        for (OrderDTO orderDTO : orderDTOS) {
            Assert.assertNotNull(orderService.getOrder(orderDTO.getId()));
        }
    }

    @Test
    public void ShouldGetProductsFromOrders() {
        List<OrderDTO> orderDTOS = orderService.getOrders();
        for (OrderDTO orderDTO : orderDTOS) {
            for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
                System.out.println(orderItemDTO);
            }
        }
    }

    @Test
    public void ShouldGetCountProduct() {
        List<OrderDTO> orderDTOS = orderService.getOrders();
        for (OrderDTO orderDTO : orderDTOS) {
            Assert.assertNotNull(orderService.getProducts(orderDTO));
        }
    }


}
