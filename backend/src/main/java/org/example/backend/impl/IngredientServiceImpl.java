package org.example.backend.impl;

import org.example.backend.Dto.IngredientDTO;
import org.example.backend.Entity.Ingredient;
import org.example.backend.Repository.IngredientRepository;
import org.example.backend.Service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    // 🔹 등록 (Create)
    @Override
    public void saveIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setBarcode(ingredientDTO.getBarcode());
        ingredient.setName(ingredientDTO.getName());
        ingredient.setBrand(ingredientDTO.getBrand());
        ingredient.setCategory(ingredientDTO.getCategory());
        ingredient.setImage(ingredientDTO.getImage());
        ingredient.setExpirationDate(ingredientDTO.getExpirationDate());
        ingredient.setUserID(ingredientDTO.getUserID());

        ingredientRepository.save(ingredient);
    }

    // 🔹 조회 (Read)
    @Override
    public List<IngredientDTO> getIngredients(String userID) {
        return ingredientRepository.findByUserID(userID)
                .stream()
                .map(i -> new IngredientDTO(
                        i.getId(),
                        i.getBarcode(),
                        i.getName(),
                        i.getBrand(),
                        i.getCategory(),
                        i.getImage(),
                        i.getExpirationDate(),
                        i.getUserID()
                ))
                .collect(Collectors.toList());
    }

    // 🔹 삭제 (Delete)
    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    // 🔹 수정 (Update)
    @Override
    public void updateIngredient(Long id, IngredientDTO dto) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));

        ingredient.setBarcode(dto.getBarcode());
        ingredient.setName(dto.getName());
        ingredient.setBrand(dto.getBrand());
        ingredient.setCategory(dto.getCategory());
        ingredient.setImage(dto.getImage());
        ingredient.setExpirationDate(dto.getExpirationDate());
        ingredientRepository.save(ingredient);
    }
}
