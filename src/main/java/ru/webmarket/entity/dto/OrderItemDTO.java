package ru.webmarket.entity.dto;

public class OrderItemDTO {

    private Long id;

    private Long orderId;

    private Long productId;

    private ProductDTO product;

    private int count;

    public OrderItemDTO() {

    }

    public OrderItemDTO(ProductDTO product) {
        this.product = product;
    }

    public OrderItemDTO(Long id, ProductDTO product, int count) {
        this.id = id;
        this.product = product;
        this.count = count;
    }

    public OrderItemDTO(ProductDTO product, int count) {
        this.product = product;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        return productId != null ? productId.equals(that.productId) : that.productId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", product=" + product +
                ", count=" + count +
                '}';
    }
}
