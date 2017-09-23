package ru.webmarket.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shoppcartid")
    private Long id;

    @Transient
    @JoinColumn(name = "userid")
    private User user;

    @Transient
    @ManyToMany
    @JoinTable(name = "shopping_list", joinColumns = @JoinColumn(name = "shoppcartid"),
            inverseJoinColumns = @JoinColumn(name = "productid"))
    private List<Product> products;



}
