package com.leon.ecm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Film(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;
        return (this.id != null) && (film.getId() != null) && this.id.equals(film.getId());
    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (sameAsFormer(category)) return;
        Category oldCategory = this.category;
        this.category = category;
        if (oldCategory != null) {
            oldCategory.remove(this);
        }

        if (category != null) {
            category.add(this);
        }
    }

    private boolean sameAsFormer(Category newCategory) {
        return (this.category == null) ? (newCategory == null) : (this.category.equals(newCategory));
    }

}
