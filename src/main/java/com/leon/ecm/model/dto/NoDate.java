package com.leon.ecm.model.dto;

import com.leon.ecm.model.Category;
import com.leon.ecm.model.Film;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "noDate", types = Film.class)
interface NoDate {

    String getName();

    double getDuration();

    String getCountry();

    Category getCategory();

}
