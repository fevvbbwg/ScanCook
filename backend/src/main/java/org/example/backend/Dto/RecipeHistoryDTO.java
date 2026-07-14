package org.example.backend.Dto;

import lombok.Getter;
import lombok.Setter;
import org.example.backend.Entity.RecipeHistory;

@Getter
@Setter
public class RecipeHistoryDTO {

    private Long id;
    private String userID;
    private String title;
    private String recipeId;
    private String imageUrl;

    public RecipeHistoryDTO() {}

    public RecipeHistoryDTO(RecipeHistory entity) {
        this.id = entity.getId();
        this.userID = entity.getUser() != null ? entity.getUser().getUserID() : null;

        if (entity.getRecipeDetail() != null) {
            this.title = entity.getRecipeDetail().getRcpTtl();
            this.recipeId = String.valueOf(entity.getRecipeDetail().getRcpSno());
            this.imageUrl = entity.getRecipeDetail().getRcpImgUrl();
        } else {
            this.title = entity.getTitle();
            this.recipeId = null;
            this.imageUrl = entity.getImageUrl();
        }
    }
}
