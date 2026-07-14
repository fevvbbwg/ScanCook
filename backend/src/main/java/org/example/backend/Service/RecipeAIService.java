package org.example.backend.Service;

import org.example.backend.Entity.RecipeDetail;
import java.util.List;
import java.util.Map;

public interface RecipeAIService {
    Map<String, List<RecipeDetail>> getCategorizedRecipesByAI();
}
