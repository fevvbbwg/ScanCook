package org.example.backend.Controller;

import org.example.backend.Dto.IngredientDTO;
import org.example.backend.Service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    // 🔹 등록 (Create)
    @PostMapping("/save")
    public void saveIngredient(@RequestBody IngredientDTO dto) {
        ingredientService.saveIngredient(dto);
    }

    // 🔹 조회 (Read)
    @GetMapping("/list")
    public List<IngredientDTO> getIngredients(@RequestParam String userID) {
        return ingredientService.getIngredients(userID);
    }

    // 🔹 삭제 (Delete)
    @DeleteMapping("/delete/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
    }

    // 🔹 수정 (Update)
    @PutMapping("/update/{id}")
    public void updateIngredient(@PathVariable Long id, @RequestBody IngredientDTO dto) {
        ingredientService.updateIngredient(id, dto);
    }
}
