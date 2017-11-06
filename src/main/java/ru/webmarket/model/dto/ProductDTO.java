package ru.webmarket.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс DTO для {@link ru.webmarket.model.entity.Product}.
 */

@Getter
@Setter
@EqualsAndHashCode
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private String description;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
