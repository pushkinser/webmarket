package ru.webmarket.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productid")
    private Long id;

    @Column(name = "label")
    private String name;

    private Double price;

    @Transient
    @ManyToMany
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "productid"),
            inverseJoinColumns = @JoinColumn(name = "categoriesid"))
    private Set<Category> categories;

    @Transient
    @ManyToMany
    @JoinTable(name = "shopping_cart")
    private Set<ShoppingCart> shoppingCarts;

    @Transient
    @ManyToMany
    @JoinTable(name = "orders")
    private Set<Order> orders;


}