package io.devdezyn.recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.devdezyn.recipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
  Optional<UnitOfMeasure> findByDescription(String description);
}
