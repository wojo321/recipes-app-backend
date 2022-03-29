package com.courseapp.backend.model.recipe;

import com.courseapp.backend.model.GenericDTO;
import com.courseapp.backend.model.ingredient.IngredientDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
public class RecipeDTO extends RepresentationModel<RecipeDTO> implements GenericDTO {
    long id;
    String name;
    String description;
    String imagePath;
    Iterable<IngredientDTO> ingredients;

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
