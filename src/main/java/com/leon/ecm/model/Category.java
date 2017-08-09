package com.leon.ecm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@ToString(exclude = "films")
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.DETACH, CascadeType.REMOVE})
    private Collection<Film> films = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return (this.id != null) && (category.getId() != null) && this.id.equals(category.getId());
    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    public Collection<Film> getFilms() {
        return new ArrayList<>(films);
    }

    public void add(Film film) {
        if (this.films.contains(film)) return;
        this.films.add(film);
        film.setCategory(this);
    }

    public void remove(Film film) {
        if (!this.films.contains(film)) return;
        this.films.remove(film);
        film.setCategory(null);
    }

}
