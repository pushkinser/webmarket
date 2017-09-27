package ru.webmarket.entity;

import javax.persistence.*;
import java.util.List;


/**
 *
 * TODO: equals/hashCode for List<RoleService>
 *
 *
 */


@Entity
@Table(name = "categories")
public class CategoryDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "categories_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products;

    public CategoryDTO(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public CategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDTO categoryDTO = (CategoryDTO) o;

        if (id != null ? !id.equals(categoryDTO.id) : categoryDTO.id != null) return false;
        return name != null ? name.equals(categoryDTO.name) : categoryDTO.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryService{" +
                "id=" + id +
                ", name='" + name + '\'' +
 //               ", products=" + products +
                '}';
    }
}
