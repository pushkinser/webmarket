package ru.webmarket.entity.dto;

import ru.webmarket.entity.Order;
import ru.webmarket.entity.User;

import java.util.List;

public class ShoppingCartDTO {
    private Long id;

    private OrderDTO order;

    public ShoppingCartDTO () {

    }

    public ShoppingCartDTO(Long id) {
        this.id = id;
    }

    public ShoppingCartDTO(Long id, OrderDTO order) {
        this.id = id;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }


    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
                "id=" + id +
                ", order=" + order +
                '}';
    }
}
