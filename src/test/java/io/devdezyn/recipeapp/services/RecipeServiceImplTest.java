package io.devdezyn.recipeapp.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.devdezyn.recipeapp.domain.Recipe;
import io.devdezyn.recipeapp.repositories.RecipeRepository;

public class RecipeServiceImplTest {
  RecipeServiceImpl recipeService;

  @Mock
  RecipeRepository recipeRepository;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.openMocks(this);

    recipeService = new RecipeServiceImpl(recipeRepository);
  }

  @Test
  public void getRecipes() throws Exception {
    Recipe recipe = new Recipe();
    HashSet<Recipe> mockRecipesFromRepo = new HashSet<>();
    mockRecipesFromRepo.add(recipe);

    when(recipeRepository.findAll()).thenReturn(mockRecipesFromRepo);

    Set<Recipe> recipes = recipeService.getRecipes();

    assertEquals(recipes.size(), 1);
    verify(recipeRepository, times(1)).findAll();
  }
}
