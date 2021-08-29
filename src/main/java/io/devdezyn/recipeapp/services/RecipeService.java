package io.devdezyn.recipeapp.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import io.devdezyn.recipeapp.domain.Recipe;

public interface RecipeService {
  Set<Recipe> getRecipes();
}
