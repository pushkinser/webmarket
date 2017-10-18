package ru.webmarket.controller.rest.requestBody;

import java.io.Serializable;

public class ProductBodyJson implements Serializable {
    Long id;
    Integer count;
    Boolean flag;

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

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
