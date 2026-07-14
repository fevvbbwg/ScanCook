package org.example.backend.impl;

import org.example.backend.Dto.RecipeHistoryDTO;
import org.example.backend.Entity.RecipeDetail;
import org.example.backend.Entity.RecipeHistory;
import org.example.backend.Entity.User;
import org.example.backend.Repository.RecipeDetailRepository;
import org.example.backend.Repository.RecipeHistoryRepository;
import org.example.backend.Repository.UserRepository;
import org.example.backend.Service.RecipeHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeHistoryServiceImpl implements RecipeHistoryService {

    private final RecipeHistoryRepository recipeHistoryRepository;
    private final UserRepository userRepository;
    private final RecipeDetailRepository recipeDetailRepository;

    public RecipeHistoryServiceImpl(RecipeHistoryRepository recipeHistoryRepository,
                                    UserRepository userRepository,
                                    RecipeDetailRepository recipeDetailRepository) {
        this.recipeHistoryRepository = recipeHistoryRepository;
        this.userRepository = userRepository;
        this.recipeDetailRepository = recipeDetailRepository;
    }

    @Override
    public void saveRecipeHistory(String userID, String title, String recipeIdStr, String imageUrl) {
        User user = userRepository.findById(Long.valueOf(userID)).orElse(null);

        // 🔹 RCP_SNO(Long) 조회
        RecipeDetail recipeDetail = recipeDetailRepository.findByRcpSnoNative(Long.valueOf(recipeIdStr))
                .orElse(null);

        RecipeHistory history = new RecipeHistory();
        history.setUser(user);
        history.setTitle(title);
        history.setRecipeDetail(recipeDetail);
        history.setImageUrl(imageUrl);

        recipeHistoryRepository.save(history);
    }

    @Override
    public List<RecipeHistoryDTO> getUserRecipeHistory(String userID) {
        return recipeHistoryRepository.findByUser_UserID(userID)
                .stream()
                .map(RecipeHistoryDTO::new)
                .collect(Collectors.toList());
    }
}
