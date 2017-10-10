package ru.webmarket.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders_items")
public class OrderItem {

    @Id
    @Column(name = "orders_items_id")
    private Long id;

    @Column(name = "products_id", insertable = false, updatable = false)
    private Long productId;

    @Column(name = "orders_id", insertable = false, updatable = false)
    private Long orderId;

    @Column(name = "count")
    private int count;

    @ManyToOne
    @JoinColumn(name = "orders_id",referencedColumnName = "orders_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "products_id",referencedColumnName = "products_id")
    private Product product;

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (count != orderItem.count) return false;
        if (id != null ? !id.equals(orderItem.id) : orderItem.id != null) return false;
        if (productId != null ? !productId.equals(orderItem.productId) : orderItem.productId != null) return false;
        return orderId != null ? orderId.equals(orderItem.orderId) : orderItem.orderId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", productId=" + productId +
                ", orderId=" + orderId +
                ", count=" + count +
                '}';
    }
}
