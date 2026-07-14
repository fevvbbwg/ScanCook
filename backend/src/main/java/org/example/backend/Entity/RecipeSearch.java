package org.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RecipeSearch {

    @Id
    private String rcpSno;
    private String rcpTtl;
    private String ckgNm;
    private String rgtrNm;
    private int inqCnt;
    private int rcmmCnt;
    private int srapCnt;
    private String firstRegDt;
    private String rcpImgUrl;
}
