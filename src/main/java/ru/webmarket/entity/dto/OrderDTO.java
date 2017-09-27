package ru.webmarket.entity.dto;

import ru.webmarket.entity.Product;
import ru.webmarket.entity.ShoppingCart;
import ru.webmarket.entity.User;

import java.util.List;

public class OrderDTO {

    private Long id;

    private Double total;

    private UserDTO user;

    private List<ProductDTO> products;

    private ShoppingCartDTO shoppingCart;

    public OrderDTO () {

    }

    public OrderDTO(Long id, Double total, UserDTO user, List<ProductDTO> products) {
        this.id = id;
        this.total = total;
        this.user = user;
        this.products = products;
    }

    public OrderDTO(Long id, Double total, UserDTO user) {
        this.id = id;
        this.total = total;
        this.user = user;
    }

    public OrderDTO(Long id, Double total, UserDTO user, ShoppingCartDTO shoppingCart) {
        this.id = id;
        this.total = total;
        this.user = user;
        this.shoppingCart = shoppingCart;
    }

    public OrderDTO(Long id, Double total, UserDTO user, List<ProductDTO> products, ShoppingCartDTO shoppingCart) {
        this.id = id;
        this.total = total;
        this.user = user;
        this.products = products;
        this.shoppingCart = shoppingCart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public ShoppingCartDTO getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartDTO shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", total=" + total +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
