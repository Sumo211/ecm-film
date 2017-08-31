package com.leon.ecm.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private Collection<Product> products = new ArrayList<>();

    public Category() {

    }

    @Builder
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
