package org.example.backend.Service;

import org.example.backend.Entity.RecipeSearch;

import java.util.List;
import java.util.Optional;

public interface RecipeSearchService {

    // 전체 레시피 목록
    List<RecipeSearch> getAllRecipes();

    // 특정 레시피 상세
    Optional<RecipeSearch> getRecipeById(String rcpSno);

    // 검색
    List<RecipeSearch> searchRecipes(String keyword);

    // 오늘의 레시피 (최신순)
    List<RecipeSearch> getTodayRecipes();

    // 추천 많은 레시피
    List<RecipeSearch> getPopularRecipes();
}
