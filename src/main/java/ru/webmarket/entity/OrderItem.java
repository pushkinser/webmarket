package ru.webmarket.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_items_id")
    private Long id;

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
        if (order != null ? !order.equals(orderItem.order) : orderItem.order != null) return false;
        return product != null ? product.equals(orderItem.product) : orderItem.product == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + count;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + order +
                ", count=" + count +
                '}';
    }
}
