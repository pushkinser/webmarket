package ru.webmarket.controller.rest.requestBody;

import org.hibernate.type.descriptor.java.StringTypeDescriptor;

import java.io.Serializable;

public class ProductBodyJson implements Serializable{

    String name;
    Double price;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
