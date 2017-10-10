package ru.webmarket.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.entity.dto.OrderItemDTO;
import ru.webmarket.service.impl.OrderItemServiceImpl;

import java.util.List;

public class OrderItemServiceTest extends AppTest {

    @Autowired
    private OrderItemServiceImpl orderItemService;

    @Test
    public void shouldGetAllOrderItems() {
        List<OrderItemDTO> orderItemDTOS = orderItemService.getOrdersItems();
        Assert.assertNotNull(orderItemDTOS);
    }

}
