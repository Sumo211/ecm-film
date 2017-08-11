package com.leon.ecm.model.dto;

import com.leon.ecm.model.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "defaultProduct", types = Product.class)
interface DefaultProduct {

    String getName();

    String getCode();

    double getPrice();

}
