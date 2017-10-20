package ru.webmarket.controller.rest.requestBody;

import java.io.Serializable;

/*
    @param(flag) принимает логическое значение удаление всех товаров корзины
 */

public class OrderItemBodyJson implements Serializable {
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
