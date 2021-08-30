package io.devdezyn.recipeapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import io.devdezyn.recipeapp.domain.Recipe;
import io.devdezyn.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

  private RecipeRepository recipeRepository;

  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public Set<Recipe> getRecipes() {
    log.debug("RecipeServiceImpl");

    Set<Recipe> recipeSet = new HashSet<>();

    recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
    
    return recipeSet;
  }

}
