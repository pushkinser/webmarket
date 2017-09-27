package ru.webmarket.entity;

import javax.persistence.*;
import java.util.List;


/**
 *
 */


@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "orders_id",referencedColumnName = "orders_id")
    private Order order;


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCart that = (ShoppingCart) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return order != null ? order.equals(that.order) : that.order == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", user=" + user +
                //", order=" + order +
                '}';
    }
}
