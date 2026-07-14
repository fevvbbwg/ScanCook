package org.example.backend.Service;

import org.example.backend.Dto.RecipeHistoryDTO;
import java.util.List;

public interface RecipeHistoryService {
    void saveRecipeHistory(String userID, String title, String recipeId, String imageUrl);
    List<RecipeHistoryDTO> getUserRecipeHistory(String userID);
}
