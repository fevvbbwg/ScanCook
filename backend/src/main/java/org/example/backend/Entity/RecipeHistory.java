package org.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "recipe_history")
public class RecipeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자 연관
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user;

    // 레시피 연관
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeId", referencedColumnName = "RCP_SNO")
    private RecipeDetail recipeDetail;


    @Column(length = 255)
    private String title; // 단순 저장용 타이틀

    @Column(length = 255)
    private String imageUrl;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
}
