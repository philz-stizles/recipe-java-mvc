package io.devdezyn.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.devdezyn.recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
  private RecipeService recipeService;


  public IndexController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }


  @RequestMapping({"", "/", "/index", "index.html"})
  public String getIndexPage(Model model) {
    log.debug("Getting Index Page");
    var recipes = recipeService.getRecipes();
    model.addAttribute("recipes", recipes);

    System.out.println("recipes.size(): %s".formatted(recipes.size()));
    
    return "index";
  }
}
