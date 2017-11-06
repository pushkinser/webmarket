package ru.webmarket.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.webmarket.model.entity.Role;
import ru.webmarket.model.entity.ShoppingCart;

import java.util.List;

/**
 * Класс DTO для {@link ru.webmarket.model.entity.User}.
 */

@Getter
@Setter
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    private String userName;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<RoleDTO> roles;


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
