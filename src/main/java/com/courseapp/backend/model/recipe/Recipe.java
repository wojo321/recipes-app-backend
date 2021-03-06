package com.courseapp.backend.model.recipe;

import com.courseapp.backend.model.BaseEntity;
import com.courseapp.backend.model.GenericEntity;
import com.courseapp.backend.model.ingredient.Ingredient;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "recipes")
public class Recipe implements GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="recipe_id")
    private long id;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    private String name;

    @NotBlank
    private String description;
    private String imagePath;

    @OneToMany(targetEntity = Ingredient.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private Set<Ingredient> ingredients;

    @Embedded
    private BaseEntity baseEntity = new BaseEntity();

    public Recipe(long id, String name, String description, String imagePath, Set<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
