package ru.webmarket.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.sql.rowset.Joinable;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    private List<Product> products;

    @OneToOne(mappedBy = "order")
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public Order() {

    }

    public Order(Long id) {
        this.id = id;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    //    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        return shoppingCart != null ? shoppingCart.equals(order.shoppingCart) : order.shoppingCart == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (shoppingCart != null ? shoppingCart.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", products=" + products +
                '}';
    }


}
