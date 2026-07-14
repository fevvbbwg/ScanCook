package org.example.backend.Service;

import org.example.backend.Dto.IngredientDTO;
import java.util.List;

public interface IngredientService {
    void saveIngredient(IngredientDTO ingredientDTO);
    List<IngredientDTO> getIngredients(String userID);
    void deleteIngredient(Long id);
    void updateIngredient(Long id, IngredientDTO dto);
}
