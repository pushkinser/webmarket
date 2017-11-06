package ru.webmarket.controller.rest.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Когда flag отвечает за удаление всех OrderItem, когда принимает значение true.
 */

@Getter
@Setter
public class OrderItemBodyJson implements Serializable {

    Long id;
    Integer count;
    Boolean flag;
}