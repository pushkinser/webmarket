package ru.webmarket.controller.rest;

import java.io.Serializable;

public class ProductBodyJson implements Serializable {
    Long id;
    Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
