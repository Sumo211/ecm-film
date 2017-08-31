package com.leon.ecm.discount;

import com.leon.ecm.product.Product;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private double value;

    private long start;

    private long stop;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Discount() {

    }

    @Builder
    public Discount(double value, long from, long to) {
        this.value = value;
        this.start = from;
        this.stop = to;
    }

}
