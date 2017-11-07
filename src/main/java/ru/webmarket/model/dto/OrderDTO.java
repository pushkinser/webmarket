package ru.webmarket.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс DTO для {@link ru.webmarket.model.entity.Order}.
 */

@Getter
@Setter
@EqualsAndHashCode
public class OrderDTO {

    private Long id;
    private String address;
    private UserDTO user;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", user=" + user +
                '}';
    }
}
