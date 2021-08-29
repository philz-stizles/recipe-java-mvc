package io.devdezyn.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import io.devdezyn.recipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
  
}
