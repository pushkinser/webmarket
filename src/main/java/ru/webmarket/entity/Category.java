package ru.webmarket.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoriesid")
    private Long id;

    @Column(name = "categoriesname")
    private String name;

    @Transient
    @ManyToMany(mappedBy = "products")
    private List<Product> products;

}
