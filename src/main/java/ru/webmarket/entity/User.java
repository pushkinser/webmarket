package ru.webmarket.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Сергей
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid"))
    private Set<Role> roles;


    @OneToOne
    @JoinTable(name = "shopping_cart")
    private ShoppingCart ShoppingCart;

    public ShoppingCart getShopping_cart() {
        return ShoppingCart;
    }

    public void setShopping_cart(ShoppingCart shopping_cart) {
        this.ShoppingCart = shopping_cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setNane(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}