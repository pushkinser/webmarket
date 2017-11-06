package ru.webmarket.model.entity;

import lombok.Data;
import ru.webmarket.model.entity.Order;
import ru.webmarket.model.entity.Product;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_items_id")
    private Long id;

    @Column(name = "count")
    private int count;

    /**
     * Реализуется без каскада : OrderItemRepository не создает новый Order.
     *
     * 3.11.17 Добавлен каскад с MERGE, убран в классе Order: List<OrderItem>.
     */
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "orders_id")
    private Order order;

    /**
     * Реализуется без (Persist) создания Product : OrderItemRepository не создает новый Product.
     */
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "products_id")
    private Product product;

}
