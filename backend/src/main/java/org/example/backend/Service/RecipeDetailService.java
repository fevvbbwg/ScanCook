package org.example.backend.Service;

import org.example.backend.Dto.RecipeDetailDTO;
import org.example.backend.Entity.RecipeDetail;
import java.util.List;

public interface RecipeDetailService {
    RecipeDetailDTO getRecipeDetail(Long id);
    List<RecipeDetail> getRandomRecipes(int count);
    List<RecipeDetail> getRecipesByPage(int page, int size);

    // ✅ 인기 레시피
    List<RecipeDetail> getPopularRecipes(int page, int size);
}
