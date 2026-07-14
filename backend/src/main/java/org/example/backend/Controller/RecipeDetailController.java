package org.example.backend.Controller;

import org.example.backend.Dto.RecipeDetailDTO;
import org.example.backend.Service.RecipeDetailService;
import org.example.backend.Entity.RecipeDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeDetailController {

    private final RecipeDetailService recipeDetailService;

    public RecipeDetailController(RecipeDetailService recipeDetailService) {
        this.recipeDetailService = recipeDetailService;
    }

    // 상세 레시피
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDetailDTO> getRecipe(@PathVariable String id) {
        RecipeDetailDTO dto = recipeDetailService.getRecipeDetail(Long.valueOf(id));
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    // 오늘의 레시피 (초기 4개 랜덤)
    @GetMapping("/today")
    public ResponseEntity<List<RecipeDetail>> getTodayRecipes() {
        List<RecipeDetail> recipes = recipeDetailService.getRandomRecipes(4);
        return ResponseEntity.ok(recipes);
    }

    // 오늘의 레시피 더보기 (페이지 단위 10개 랜덤)
    @GetMapping("/today-more")
    public ResponseEntity<List<RecipeDetail>> getTodayMoreRecipes(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<RecipeDetail> recipes = recipeDetailService.getRecipesByPage(page, size);
        return ResponseEntity.ok(recipes);
    }

    // 추천수 많은 레시피 (초기 4개)
    @GetMapping("/popular")
    public ResponseEntity<List<RecipeDetail>> getPopularRecipes(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "4") int size) {
        List<RecipeDetail> recipes = recipeDetailService.getPopularRecipes(page, size);
        return ResponseEntity.ok(recipes);
    }

    // 인기 레시피 더보기 (페이지 단위 10개)
    @GetMapping("/popular-more")
    public ResponseEntity<List<RecipeDetail>> getPopularMoreRecipes(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<RecipeDetail> recipes = recipeDetailService.getPopularRecipes(page, size);
        return ResponseEntity.ok(recipes);
    }
}
