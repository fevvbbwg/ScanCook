package org.example.backend.Dto;

import lombok.Getter;
import lombok.Setter;
import org.example.backend.Entity.RecipeDetail;

@Getter
@Setter
public class RelatedRecipeDTO {
    private Long id;
    private String title;
    private String image;

    public RelatedRecipeDTO(RecipeDetail entity) {
        this.id = entity.getRcpSno();
        this.title = entity.getRcpTtl();
        this.image = entity.getRcpImgUrl();
    }
}
