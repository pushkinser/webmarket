package ru.webmarket.entity.dto;

public class OrderItemDTO {

    private Long id;

    private OrderDTO order;

    private ProductDTO product;

    private int count;

    public OrderItemDTO() {

    }

    public OrderItemDTO(ProductDTO product) {
        this.product = product;
    }

    public OrderItemDTO(OrderDTO order, ProductDTO product, int count) {
        this.order = order;
        this.product = product;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO productDTO) {
        this.product = productDTO;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemDTO that = (OrderItemDTO) o;

        if (count != that.count) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }
}
