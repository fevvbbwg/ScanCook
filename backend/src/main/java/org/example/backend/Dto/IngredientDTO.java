package org.example.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {
    private Long id;
    private String barcode;
    private String name;
    private String brand;
    private String category;
    private String image;
    private String expirationDate;
    private String userID;
}
