package org.example.backend.Controller;

import org.example.backend.Dto.RecipeHistoryDTO;
import org.example.backend.Service.RecipeHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe-history")
public class RecipeHistoryController {

    private final RecipeHistoryService recipeHistoryService;

    public RecipeHistoryController(RecipeHistoryService recipeHistoryService) {
        this.recipeHistoryService = recipeHistoryService;
    }

    // 🔹 레시피 기록 저장
    @PostMapping("/save")
    public ResponseEntity<String> saveRecipeHistory(@RequestParam String userID,
                                                    @RequestParam String title,
                                                    @RequestParam String recipeId,
                                                    @RequestParam String imageUrl) {
        recipeHistoryService.saveRecipeHistory(userID, title, recipeId, imageUrl);
        return ResponseEntity.ok("레시피 기록이 저장되었습니다.");
    }

    // 🔹 특정 사용자의 레시피 기록 조회
    @GetMapping("/{userID}")
    public ResponseEntity<List<RecipeHistoryDTO>> getUserRecipeHistory(@PathVariable String userID) {
        List<RecipeHistoryDTO> historyList = recipeHistoryService.getUserRecipeHistory(userID);
        return ResponseEntity.ok(historyList);
    }
}
