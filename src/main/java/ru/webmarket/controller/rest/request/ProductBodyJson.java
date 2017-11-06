package ru.webmarket.controller.rest.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductBodyJson implements Serializable {

    String name;
    Double price;
    String description;

}