package org.example.backend.Controller;

import org.example.backend.Entity.RecipeDetail;
import org.example.backend.Service.RecipeAIService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ai/recipes") // ✅ 경로 분리
@CrossOrigin(origins = "*")
public class RecipeAIController {

    private final RecipeAIService recipeAIService;

    public RecipeAIController(RecipeAIService recipeAIService) {
        this.recipeAIService = recipeAIService;
    }

    @GetMapping("/categorized")
    public Map<String, List<RecipeDetail>> getCategorizedRecipes() {
        return recipeAIService.getCategorizedRecipesByAI();
    }
}

