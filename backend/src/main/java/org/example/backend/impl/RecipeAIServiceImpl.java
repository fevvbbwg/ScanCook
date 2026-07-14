package org.example.backend.impl;

import org.example.backend.Entity.RecipeDetail;
import org.example.backend.Repository.RecipeAIRepository;
import org.example.backend.Service.RecipeAIService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeAIServiceImpl implements RecipeAIService {

    private final RecipeAIRepository recipeAIRepository;

    public RecipeAIServiceImpl(RecipeAIRepository recipeAIRepository) {
        this.recipeAIRepository = recipeAIRepository;
    }

    @Override
    public Map<String, List<RecipeDetail>> getCategorizedRecipesByAI() {
        Map<String, List<RecipeDetail>> categorized = new LinkedHashMap<>();

        // 🔹 시연용 키워드 기반 AI 시뮬레이션
        Map<String, List<String>> aiKeywords = new HashMap<>();
        aiKeywords.put("제철 음식", Arrays.asList("무", "굴", "배추", "고등어"));
        aiKeywords.put("다이어트 음식", Arrays.asList("닭가슴살", "두부", "샐러드"));
        aiKeywords.put("간단 요리", Arrays.asList("계란", "김치", "참치"));
        aiKeywords.put("인기 레시피", Collections.emptyList());

        for (Map.Entry<String, List<String>> entry : aiKeywords.entrySet()) {
            String category = entry.getKey();
            List<String> keywords = entry.getValue();
            List<RecipeDetail> recipes = new ArrayList<>();

            if (keywords.isEmpty()) {
                // 인기순 레시피 시뮬레이션
                recipes = recipeAIRepository.findTopPopularRecipes();
            } else {
                // 키워드 매칭
                for (String keyword : keywords) {
                    List<RecipeDetail> found = recipeAIRepository.findByIngredientKeyword(keyword);
                    recipes.addAll(found);
                }
            }

            // 중복 제거
            List<RecipeDetail> distinctList = new ArrayList<>(new HashSet<>(recipes));
            categorized.put(category, distinctList);
        }

        return categorized;
    }
}
