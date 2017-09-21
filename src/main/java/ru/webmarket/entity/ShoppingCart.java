package ru.webmarket.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinTable(name = "users")
    private User user;

    @ManyToMany
    @JoinTable(name = "shopping_list", joinColumns = @JoinColumn(name = "shoppcartid"),
            inverseJoinColumns = @JoinColumn(name = "productid"))
    private Set<Product> products;


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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
