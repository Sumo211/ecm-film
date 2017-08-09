package com.leon.ecm;

import com.leon.ecm.model.Category;
import com.leon.ecm.model.Film;
import com.leon.ecm.repository.CategoryRepository;
import com.leon.ecm.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(CategoryRepository categoryRepository, FilmRepository filmRepository) {
        return evt -> {
            //Case1
            Category category = categoryRepository.save(new Category("cat1"));
            Film film1 = new Film("film1");
            film1.setCategory(category);
            Film film2 = new Film("film2");
            film2.setCategory(category);
            filmRepository.save(Arrays.asList(film1, film2));

            //Case2
            /*Film film1 = filmRepository.save(new Film("film1"));
            Film film2 = filmRepository.save(new Film("film2"));
            Category category = new Category("cat1");
            category.add(film1);
            category.add(film2);
            categoryRepository.save(category);
            filmRepository.save(Arrays.asList(film1, film2));*/
        };
    }

}
