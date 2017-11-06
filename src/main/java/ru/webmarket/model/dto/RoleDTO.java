package ru.webmarket.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс DTO для {@link ru.webmarket.model.entity.Role}.
 */

@Getter
@Setter
@EqualsAndHashCode
public class RoleDTO {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
