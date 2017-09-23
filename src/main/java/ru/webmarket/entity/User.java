package ru.webmarket.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Сергей
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Transient
    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid"))
    private Set<Role> roles;

    @Transient
    @OneToOne (mappedBy = "ShoppingCart")
    private ShoppingCart shoppingCart;

    @Transient
    @OneToMany
    @JoinTable(name = "order_list", joinColumns = @JoinColumn(name = "userid"),
    inverseJoinColumns = @JoinColumn(name = "orderid"))
    private List<Order> orderList;

    public User(String userName, String lastName, String email, String password) {
        this.userName = userName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
//    public ShoppingCart getShoppingCart() {
//        return shoppingCart;
//    }
//
//    public void setShoppingCart(ShoppingCart shoppingCart) {
//        this.shoppingCart = shoppingCart;
//    }
//
//    public List<Order> getOrderList() {
//        return orderList;
//    }
//
//    public void setOrderList(List<Order> orderList) {
//        this.orderList = orderList;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
//        if (password != null ? !password.equals(user.password) : user.password != null) return false;
//        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
//        if (shoppingCart != null ? !shoppingCart.equals(user.shoppingCart) : user.shoppingCart != null) return false;
//        return orderList != null ? orderList.equals(user.orderList) : user.orderList == null;
        return password != null ? !password.equals(user.password) : user.password != null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (roles != null ? roles.hashCode() : 0);
//        result = 31 * result + (shoppingCart != null ? shoppingCart.hashCode() : 0);
//        result = 31 * result + (orderList != null ? orderList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
//                ", roles=" + roles +
//                ", shoppingCart=" + shoppingCart +
//                ", orderList=" + orderList +
                '}';
    }
}