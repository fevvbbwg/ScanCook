package org.example.backend.Service;


import org.example.backend.Dto.RecipeHistoryDTO;

import java.util.List;

public interface RecipeService {
    List<RecipeHistoryDTO> getUserRecipeHistory(String userID);
}
