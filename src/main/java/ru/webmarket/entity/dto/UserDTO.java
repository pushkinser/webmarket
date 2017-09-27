package ru.webmarket.entity.dto;

import ru.webmarket.entity.Order;
import ru.webmarket.entity.Role;
import ru.webmarket.entity.ShoppingCart;

import java.util.List;

public class UserDTO {

    private Long id;

    private String userName;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private List<RoleDTO> roles;

    private ShoppingCartDTO shoppingCart;

    private List<OrderDTO> orders;


    public UserDTO() {
    }

    public UserDTO(String userName, String name, String lastName, String email, String password) {
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserDTO(Long id, String username, String name, String lastname, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

//    public UserDTO(Long id, String userName, String name, String lastName, String email, String password, Iterable<Role> roles, ShoppingCart shoppingCart, Iterable<Order> orders) {
//        this.id = id;
//        this.userName = userName;
//        this.name = name;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.roles = roles;
//        this.shoppingCart = shoppingCart;
//        this.orders = orders;
//    }
//
//    public UserDTO(User user) {
//        this.id = user.getId();
//        this.userName = user.getUserName();
//        this.name = user.getName();
//        this.lastName = user.getLastName();
//        this.email = user.getEmail();
//        this.password = user.getPassword();
//        this.roles = user.getRoles();
//        this.shoppingCart = user.getShoppingCart();
//        this.orders = user.getOrdes();
//    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public ShoppingCartDTO getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartDTO shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
               ", shoppingCart=" + shoppingCart +
               ", orders=" + orders +
                '}';
    }
}
