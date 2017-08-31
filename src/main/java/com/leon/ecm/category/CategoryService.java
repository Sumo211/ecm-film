package com.leon.ecm.category;

public interface CategoryService {

    Category findByName(String name);

    Category saveCategory(Category category);

}
