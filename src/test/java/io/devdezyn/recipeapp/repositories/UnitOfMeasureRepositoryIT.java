package io.devdezyn.recipeapp.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.devdezyn.recipeapp.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;

  @Before
  public void setUp() throws Exception {

  }
  
  @Test
  public void findByDescription() throws Exception {
    String description = "Teaspoon";
    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription(description);
    
    assertEquals(description, uomOptional.get().getDescription());
  }

}
