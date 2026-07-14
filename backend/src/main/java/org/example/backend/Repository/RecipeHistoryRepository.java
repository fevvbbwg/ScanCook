package org.example.backend.Repository;

import org.example.backend.Entity.RecipeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecipeHistoryRepository extends JpaRepository<RecipeHistory, Long> {
    List<RecipeHistory> findByUser_UserID(String userID);
}
