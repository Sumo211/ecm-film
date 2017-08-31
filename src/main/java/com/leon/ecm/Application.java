package com.leon.ecm;

import com.leon.ecm.model.Category;
import com.leon.ecm.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(CategoryRepository categoryRepository) {
        return evt -> {
            categoryRepository.save(Category.builder().name("cat1").description("des").build());
        };
    }

}
