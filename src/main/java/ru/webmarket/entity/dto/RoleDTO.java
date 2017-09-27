package ru.webmarket.entity.dto;

import ru.webmarket.entity.User;

import java.util.List;

public class RoleDTO {
    private Long id;

    private String name;

    private List<UserDTO> users;

    public RoleDTO () {

    }

    public RoleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDTO(Long id, String name, List<UserDTO> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
