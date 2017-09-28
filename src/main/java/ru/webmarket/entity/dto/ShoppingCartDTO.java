package ru.webmarket.entity.dto;

import ru.webmarket.entity.Order;
import ru.webmarket.entity.User;

import java.util.List;

public class ShoppingCartDTO {
    private Long id;

    private UserDTO user;

    private OrderDTO order;

    private List<ProductDTO> products;

    public ShoppingCartDTO () {

    }

    public ShoppingCartDTO(Long id, UserDTO user) {
        this.id = id;
        this.user = user;
    }

    public ShoppingCartDTO(Long id, UserDTO user, OrderDTO order) {
        this.id = id;
        this.user = user;
        this.order = order;
    }

    public ShoppingCartDTO(Long id, UserDTO user, OrderDTO order, List<ProductDTO> products) {
        this.id = id;
        this.user = user;
        this.order = order;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public List<ProductDTO> getProducts() {
        return order.getProducts();
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}
