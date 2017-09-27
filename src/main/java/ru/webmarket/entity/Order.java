package ru.webmarket.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    private List<Product> products;

    @OneToOne(mappedBy = "order")
    private ShoppingCart shoppingCart;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (total != null ? !total.equals(order.total) : order.total != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        return shoppingCart != null ? shoppingCart.equals(order.shoppingCart) : order.shoppingCart == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (shoppingCart != null ? shoppingCart.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                ", products=" + products +
                '}';
    }
}
