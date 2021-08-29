package io.devdezyn.recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.devdezyn.recipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
  Optional<Category> findByDescription(String description);
}
