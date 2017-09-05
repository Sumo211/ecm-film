package com.leon.ecm.producer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leon.ecm.product.Product;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@Data
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL)
    private Collection<Product> products = new ArrayList<>();

    public Producer() {

    }

    @Builder
    public Producer(String name, String country) {
        this.name = name;
        this.country = country;
    }

}
