package org.example.backend.impl;

import org.example.backend.Dto.MypageDTO;
import org.example.backend.Dto.RecipeHistoryDTO;
import org.example.backend.Entity.User;
import org.example.backend.Repository.RecipeHistoryRepository;
import org.example.backend.Repository.UserRepository;
import org.example.backend.Service.MypageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MypageServiceImpl implements MypageService {

    private final UserRepository userRepository;
    private final RecipeHistoryRepository historyRepository;

    public MypageServiceImpl(UserRepository userRepository, RecipeHistoryRepository historyRepository) {
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    public MypageDTO getMypageByUserID(String userID) {
        User user = userRepository.findByUserID(userID)
                .orElseThrow(() -> new RuntimeException("유효하지 않은 사용자입니다."));

        MypageDTO dto = new MypageDTO();
        dto.setUserID(user.getUserID());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setBirthdate(user.getBirthdate());

        return dto;
    }

    @Override
    public List<RecipeHistoryDTO> getRecipeHistoryByUserID(String userID) {
        return historyRepository.findByUser_UserID(userID)
                .stream()
                .map(RecipeHistoryDTO::new) // DTO에서 null-safe 처리
                .collect(Collectors.toList());
    }
}
