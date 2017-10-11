package ru.webmarket.entity.dto;

import java.util.List;

public class UserDTO {

    private Long id;

    private String userName;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private List<RoleDTO> roles;

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
        this.userName = username;
        this.name = name;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
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
                ", orders=" + orders +
                '}';
    }
}
