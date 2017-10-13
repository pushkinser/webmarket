package ru.webmarket.entity.dto;

import ru.webmarket.entity.Category;

import java.util.List;

public class ProductDTO {

    private Long id;

    private String name;

    private Double price;

    private List<CategoryDTO> categories;

    private String description;

    public ProductDTO() {
    }

    public ProductDTO(String name) {
        this.name = name;
    }

    public ProductDTO(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public ProductDTO(Long id, String name, Double price, List<CategoryDTO> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    public ProductDTO(String name, Double price, List<CategoryDTO> categories) {
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    public ProductDTO(ProductDTO productDTO) {
        this.id = productDTO.getId();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.categories = productDTO.getCategories();
    }

    public ProductDTO(Long id, String name, Double price, List<CategoryDTO> categories, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
        this.description = description;
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

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}