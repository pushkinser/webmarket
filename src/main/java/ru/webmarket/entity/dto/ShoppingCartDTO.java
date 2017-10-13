package ru.webmarket.entity.dto;

public class ShoppingCartDTO {
    private Long id;

    private OrderDTO order;

    private Long userId;

    public ShoppingCartDTO () {

    }

    public ShoppingCartDTO(Long id) {
        this.id = id;
    }

    public ShoppingCartDTO(Long id, OrderDTO order) {
        this.id = id;
        this.order = order;
    }

    public ShoppingCartDTO(Long id, OrderDTO order, Long userId) {
        this.id = id;
        this.order = order;
        this.userId = userId;
    }

    public ShoppingCartDTO(OrderDTO order, Long userId) {
        this.order = order;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
                "id=" + id +
                ", order=" + order +
                ", userId=" + userId +
                '}';
    }
}
