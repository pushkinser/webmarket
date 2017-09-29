package ru.webmarket.entity.dto;

import ru.webmarket.entity.Product;
import ru.webmarket.entity.ShoppingCart;
import ru.webmarket.entity.User;

import java.util.List;

public class OrderDTO {

    private Long id;

    private Double total;

    private List<ProductDTO> products;

    public OrderDTO () {

    }

    public OrderDTO(Long id, Double total, List<ProductDTO> products) {
        this.id = id;
        this.total = total;
        this.products = products;
    }

    private Double countTotal (List<ProductDTO> products) {
        Double count = Double.valueOf(0);

        for (ProductDTO productDTO: products) {
            count = count + productDTO.getPrice();
        }

        return count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return countTotal(products);
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "total=" + total +
                ", products=" + products +
                '}';
    }
}
