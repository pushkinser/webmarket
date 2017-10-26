package ru.webmarket.entity.dto;

import ru.webmarket.entity.User;

import java.util.List;

public class RoleDTO {
    private Long id;

    private String name;

    public RoleDTO () {

    }

    public RoleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDTO(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
