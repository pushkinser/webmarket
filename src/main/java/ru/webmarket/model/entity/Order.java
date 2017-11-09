package ru.webmarket.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    @Column(name = "address")
    private String address;

//    /**
//    Для добавления и удаления позиций заказа.
//     */
//    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    private List<OrderItem> orderItems;

    /**
     * Для добавления нового заказа для пользователя напрямую через Order.
     */
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

}
