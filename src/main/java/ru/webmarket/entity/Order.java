package ru.webmarket.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "reckoning")
    private Double reckoning;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getReckoning() {
        return reckoning;
    }

    public void setReckoning(Double reckoning) {
        this.reckoning = reckoning;
    }
}
