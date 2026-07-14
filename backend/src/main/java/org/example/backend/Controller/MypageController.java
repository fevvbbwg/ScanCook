package org.example.backend.Controller;

import org.example.backend.Dto.MypageDTO;
import org.example.backend.Dto.RecipeHistoryDTO;
import org.example.backend.Service.MypageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mypage")
public class MypageController {

    private final MypageService mypageService;

    public MypageController(MypageService mypageService) {
        this.mypageService = mypageService;
    }

    @GetMapping("/me")
    public ResponseEntity<MypageDTO> getMypageInfo(@RequestParam String userID) {
        return ResponseEntity.ok(mypageService.getMypageByUserID(userID));
    }
    /**
    @GetMapping("/history")
    public ResponseEntity<List<RecipeHistoryDTO>> getRecipeHistory(@RequestParam String userID) {
        return ResponseEntity.ok(mypageService.getRecipeHistoryByUserID(userID));
    }
    **/
}
