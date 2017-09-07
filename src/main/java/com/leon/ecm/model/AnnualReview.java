package com.leon.ecm.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class AnnualReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
