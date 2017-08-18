package com.leon.ecm.service;

import com.leon.ecm.model.Category;
import com.leon.ecm.repository.CategoryRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Cacheable(cacheNames = "category-name")
    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElse(new Category());
    }

}
