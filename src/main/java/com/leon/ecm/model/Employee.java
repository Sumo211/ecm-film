package com.leon.ecm.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Cubicle cubicle; // bidirectional

    @OneToOne
    private TravelProfile travelProfile; // unidirectional single-valued

    @ManyToOne
    private Department department; // bidirectional

    @ManyToOne
    private Address address; // unidirectional single-valued

    @ManyToMany(mappedBy = "employees")
    private Collection<Project> projects; // bidirectional

    @OneToMany
    private Collection<AnnualReview> annualReviews; // unidirectional multi-valued

    @ManyToMany
    private Collection<Patent> patents; // unidirectional multi-valued

}
