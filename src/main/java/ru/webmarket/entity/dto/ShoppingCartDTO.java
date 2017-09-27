package ru.webmarket.entity.dto;

import ru.webmarket.entity.Order;
import ru.webmarket.entity.User;

public class ShoppingCartDTO {
    private Long id;

    private User user;

    private Order order;

    public ShoppingCartDTO () {

    }

    public ShoppingCartDTO(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public ShoppingCartDTO(Long id, User user, Order order) {
        this.id = id;
        this.user = user;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
                "id=" + id +
                ", user=" + user +
                ", order=" + order +
                '}';
    }
}
