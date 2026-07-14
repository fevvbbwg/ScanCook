package org.example.backend.Controller;

import org.example.backend.Dto.UserRecipeDTO;
import org.example.backend.Entity.UserRecipe;
import org.example.backend.Service.UserRecipeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user-recipes")
public class UserRecipeController {

    private final UserRecipeService service;

    public UserRecipeController(UserRecipeService service) {
        this.service = service;
    }

    // ⭐ 이미지 업로드 API 추가
    @PostMapping("/upload")
    public Map<String, String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String uploadDir = "uploads/";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File dest = new File(uploadDir + fileName);

            file.transferTo(dest);

            String fileUrl = "http://192.168.68.51:8080/uploads/" + fileName;

            return Map.of("url", fileUrl);

        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("error", "Upload failed");
        }
    }

    @PostMapping("/create")
    public UserRecipe create(@RequestBody UserRecipe recipe) {
        return service.save(recipe);
    }

    @GetMapping("/list/{userId}")
    public List<UserRecipe> listByUser(@PathVariable String userId) {
        return service.getByUser(userId);
    }

    @GetMapping("/{id}")
    public UserRecipeDTO detail(@PathVariable Long id) {
        UserRecipe recipe = service.getOne(id);
        return service.toDto(recipe);
    }
}
