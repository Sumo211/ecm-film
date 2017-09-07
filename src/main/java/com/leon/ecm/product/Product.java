package com.leon.ecm.product;

import com.leon.ecm.category.Category;
import com.leon.ecm.discount.Discount;
import com.leon.ecm.producer.Producer;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String code;

    private double price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Discount discount;

    @ManyToOne
    private Producer producer;

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Collection<Category> categories = new ArrayList<>();

    public Product() {

    }

    @Builder
    public Product(String name, String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

}
