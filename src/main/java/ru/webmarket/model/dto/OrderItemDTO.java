package ru.webmarket.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс DTO для {@link ru.webmarket.model.entity.OrderItem}.
 */

@Getter
@Setter
@EqualsAndHashCode
public class OrderItemDTO {

    private Long id;
    private int count;
    private OrderDTO order;
    private ProductDTO product;

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "id=" + id +
                ", count=" + count +
                ", product=" + product +
                '}';
    }
}
