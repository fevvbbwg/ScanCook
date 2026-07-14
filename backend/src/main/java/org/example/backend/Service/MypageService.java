package org.example.backend.Service;

import org.example.backend.Dto.MypageDTO;
import org.example.backend.Dto.RecipeHistoryDTO;

import java.util.List;

public interface MypageService {
    MypageDTO getMypageByUserID(String userID);
    List<RecipeHistoryDTO> getRecipeHistoryByUserID(String userID);
}
