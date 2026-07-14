package org.example.backend.Controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.Entity.RecipeSearch;
import org.example.backend.Service.RecipeSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeSearchController {

    private final RecipeSearchService recipeSearchService;

    // 검색 기능
    @GetMapping("/search")
    public List<RecipeSearch> searchRecipes(@RequestParam String keyword) {
        return recipeSearchService.searchRecipes(keyword);
    }
}
