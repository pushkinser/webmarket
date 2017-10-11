package ru.webmarket.entity.dto;


import java.util.List;

import static java.lang.System.in;

public class OrderDTO {

    private Long id;

    private List<OrderItemDTO> orderItems;

    public OrderDTO () {

    }

    public OrderDTO(Long id, List<OrderItemDTO> orderItems) {
        this.id = id;
        this.orderItems = orderItems;
    }

    public OrderDTO(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public void addOrderItemDTO(OrderItemDTO orderItemDTO) {
        this.orderItems.add(orderItemDTO);
    }

    public void deleteOrderItemDTO(OrderItemDTO orderItemDTO) {
        if ((orderItemDTO != null)&(this.orderItems.contains(orderItemDTO)))
        this.orderItems.remove(orderItemDTO);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", orderItems=" + orderItems +
                '}';
    }
}
