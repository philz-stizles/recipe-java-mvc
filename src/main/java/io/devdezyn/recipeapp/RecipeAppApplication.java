package io.devdezyn.recipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class RecipeAppApplication {

	public static void main(String[] args) {
		log.debug("Starting Recipes App");
		SpringApplication.run(RecipeAppApplication.class, args);
	}

}
