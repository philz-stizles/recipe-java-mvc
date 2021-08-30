package io.devdezyn.recipeapp.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import io.devdezyn.recipeapp.domain.Recipe;
import io.devdezyn.recipeapp.services.RecipeService;
import jdk.jshell.Snippet.Status;

public class IndexControllerTest {
  @Mock
  Model model;
  IndexController indexController;

  @Mock
  RecipeService recipeService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.openMocks(this);

    indexController = new IndexController(recipeService);
  }

  @Test
  public void testMockMVC() throws Exception {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("index"));
  }

  @Test
  public void getIndexPage() throws Exception {
    //given
    Set<Recipe> mockRecipesFromService = new HashSet<>();

    Recipe recipe1 = new Recipe();
    recipe1.setId(1L);
    mockRecipesFromService.add(recipe1);

    Recipe recipe2 = new Recipe();
    recipe2.setId(2L);
    mockRecipesFromService.add(recipe2);

    when(recipeService.getRecipes()).thenReturn(mockRecipesFromService);

    ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

    //when
    String viewName = indexController.getIndexPage(model); 
    
    //then
    verify(recipeService, times(1)).getRecipes();
    verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
    assertEquals("index", viewName);
    
    Set<Recipe> setInController = argumentCaptor.getValue();
    assertEquals(2, setInController.size());
  }
}
