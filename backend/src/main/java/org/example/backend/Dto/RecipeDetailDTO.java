package org.example.backend.Dto;

import lombok.Getter;
import lombok.Setter;
import org.example.backend.Entity.RecipeDetail;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class RecipeDetailDTO {
    private Long rcpSno;
    private String rcpTtl;
    private String ckgNm;
    private String rgtrId;
    private String rgtrNm;
    private Integer inqCnt;
    private Integer rcmmCnt;
    private Integer srapCnt;
    private String ckgMthActoNm;
    private String ckgStaActoNm;
    private String ckgMtrlActoNm;
    private String ckgKndActoNm;
    private String ckgIpdc;
    private String ckgMtrlCn;
    private String ckgInbunNm;
    private String ckgDodfNm;
    private String ckgTimeNm;
    private String firstRegDt;
    private String rcpImgUrl;

    // ✅ 관련 레시피 목록
    private List<RelatedRecipeDTO> related;

    // 기본 생성자 (기존 필드만)
    public RecipeDetailDTO(RecipeDetail entity) {
        this.rcpSno = entity.getRcpSno();
        this.rcpTtl = entity.getRcpTtl();
        this.ckgNm = entity.getCkgNm();
        this.rgtrId = entity.getRgtrId();
        this.rgtrNm = entity.getRgtrNm();
        this.inqCnt = entity.getInqCnt();
        this.rcmmCnt = entity.getRcmmCnt();
        this.srapCnt = entity.getSrapCnt();
        this.ckgMthActoNm = entity.getCkgMthActoNm();
        this.ckgStaActoNm = entity.getCkgStaActoNm();
        this.ckgMtrlActoNm = entity.getCkgMtrlActoNm();
        this.ckgKndActoNm = entity.getCkgKndActoNm();
        this.ckgIpdc = entity.getCkgIpdc();
        this.ckgMtrlCn = entity.getCkgMtrlCn();
        this.ckgInbunNm = entity.getCkgInbunNm();
        this.ckgDodfNm = entity.getCkgDodfNm();
        this.ckgTimeNm = entity.getCkgTimeNm();
        this.firstRegDt = entity.getFirstRegDt();
        this.rcpImgUrl = entity.getRcpImgUrl();
    }

    // ✅ 관련 레시피까지 포함하는 생성자
    public RecipeDetailDTO(RecipeDetail entity, List<RecipeDetail> relatedRecipes) {
        this(entity); // 기본 필드 복사
        this.related = relatedRecipes.stream()
                .filter(r -> !r.getRcpSno().equals(entity.getRcpSno()))
                .map(RelatedRecipeDTO::new)
                .collect(Collectors.toList());
    }
}
