package ru.webmarket.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
@Data
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private Long id;

    /**
     * Реализуется без каскада : ShoppingCart не создает новового User.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    /**
     * ShoppingCart это постоянный Order для конкретного User.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    private Order order;


}