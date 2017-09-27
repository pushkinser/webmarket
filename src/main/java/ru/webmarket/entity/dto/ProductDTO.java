package ru.webmarket.entity.dto;

import ru.webmarket.entity.Category;

import java.util.List;

public class ProductDTO {

    private Long id;

    private String name;

    private Double price;

    private List<Category> categories;

    private List<OrderDTO> orders;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDTO(Long id, String name, Double price, List<Category> categories, List<OrderDTO> orders) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                ", orders=" + orders +
                '}';
    }
}
