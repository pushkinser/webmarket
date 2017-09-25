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


    @Override
    public String toString() {
        return "Order{" +
                "  id=" + id +
                "  total=" + total +
                ", user=" + user.getUserName() +
                ", products=" + products +
                '}';
    }
}
