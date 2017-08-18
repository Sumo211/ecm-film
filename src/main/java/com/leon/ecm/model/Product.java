package com.leon.ecm.model;

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

    @OneToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @ManyToMany(mappedBy = "products")
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
