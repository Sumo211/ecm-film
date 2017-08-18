package com.leon.ecm;

import com.leon.ecm.model.Category;
import com.leon.ecm.repository.CategoryRepository;
import com.leon.ecm.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(CategoryRepository categoryRepository, CategoryService categoryService) {
        return evt -> {
            categoryRepository.save(Category.builder().name("cat1").description("des").build());

            System.out.println(categoryService.findByName("cat1").getId());
        };
    }

}
