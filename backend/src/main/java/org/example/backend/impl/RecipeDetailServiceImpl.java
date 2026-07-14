package org.example.backend.impl;

import org.example.backend.Repository.RecipeDetailRepository;
import org.example.backend.Service.RecipeDetailService;
import org.example.backend.Dto.RecipeDetailDTO;
import org.example.backend.Entity.RecipeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeDetailServiceImpl implements RecipeDetailService {

    private final RecipeDetailRepository repository;

    @Autowired
    public RecipeDetailServiceImpl(RecipeDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public RecipeDetailDTO getRecipeDetail(Long id) {
        return repository.findByRcpSnoNative(id)
                .map(recipe -> {
                    List<RecipeDetail> related = repository.findRandomRecipes(4);
                    return new RecipeDetailDTO(recipe, related);
                })
                .orElse(null);
    }

    @Override
    public List<RecipeDetail> getRandomRecipes(int count) {
        return repository.findRandomRecipes(count);
    }

    @Override
    public List<RecipeDetail> getRecipesByPage(int page, int size) {
        int offset = (page - 1) * size;
        return repository.findRecipesByPage(offset, size);
    }

    @Override
    public List<RecipeDetail> getPopularRecipes(int page, int size) {
        int offset = (page - 1) * size;
        return repository.findPopularRecipes(offset, size);
    }
}
