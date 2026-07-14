package org.example.backend.impl;

import org.example.backend.Entity.RecipeSearch;
import org.example.backend.Repository.RecipeSearchRepository;
import org.example.backend.Service.RecipeSearchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeSearchServiceImpl implements RecipeSearchService {

    private final RecipeSearchRepository repository;

    public RecipeSearchServiceImpl(RecipeSearchRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RecipeSearch> getAllRecipes() {
        return repository.findAll();
    }

    @Override
    public Optional<RecipeSearch> getRecipeById(String rcpSno) {
        return repository.findById(rcpSno);
    }

    @Override
    public List<RecipeSearch> searchRecipes(String keyword) {
        return repository.findByRcpTtlContainingIgnoreCaseOrCkgNmContainingIgnoreCase(keyword, keyword);
    }

    @Override
    public List<RecipeSearch> getTodayRecipes() {
        return repository.findTop5ByOrderByFirstRegDtDesc(); // 최신순 5개
    }

    @Override
    public List<RecipeSearch> getPopularRecipes() {
        return repository.findTop5ByOrderByRcmmCntDesc(); // 추천 많은 순 5개
    }
}
