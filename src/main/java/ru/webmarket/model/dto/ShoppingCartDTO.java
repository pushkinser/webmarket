package ru.webmarket.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс DTO для {@link ru.webmarket.model.entity.ShoppingCart}.
 */

@Getter
@Setter
@EqualsAndHashCode
public class ShoppingCartDTO {

    private Long id;
    private UserDTO user;
    private OrderDTO order;

    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
                "id=" + id +
                ", user=" + user +
                ", order=" + order +
                '}';
    }
}
