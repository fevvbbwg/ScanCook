package org.example.backend.Repository;

import org.example.backend.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByUserID(String userID);
}
