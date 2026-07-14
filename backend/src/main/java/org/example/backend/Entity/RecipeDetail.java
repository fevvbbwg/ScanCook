package org.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "recipe")
public class RecipeDetail {

    @Id
    @Column(name = "RCP_SNO")
    private Long rcpSno;  // PK, BIGINT

    @Column(name = "RCP_TTL", length = 255)
    private String rcpTtl;

    @Column(name = "CKG_NM", length = 255)
    private String ckgNm;

    @Column(name = "RGTR_ID", length = 100)
    private String rgtrId;

    @Column(name = "RGTR_NM", length = 100)
    private String rgtrNm;

    @Column(name = "INQ_CNT")
    private Integer inqCnt;

    @Column(name = "RCMM_CNT")
    private Integer rcmmCnt;

    @Column(name = "SRAP_CNT")
    private Integer srapCnt;

    @Column(name = "CKG_MTH_ACTO_NM", length = 100)
    private String ckgMthActoNm;

    @Column(name = "CKG_STA_ACTO_NM", length = 100)
    private String ckgStaActoNm;

    @Column(name = "CKG_MTRL_ACTO_NM", length = 100)
    private String ckgMtrlActoNm;

    @Column(name = "CKG_KND_ACTO_NM", length = 100)
    private String ckgKndActoNm;

    @Column(name = "CKG_IPDC", columnDefinition = "TEXT")
    private String ckgIpdc;

    @Column(name = "CKG_MTRL_CN", columnDefinition = "TEXT")
    private String ckgMtrlCn;

    @Column(name = "CKG_INBUN_NM", length = 50)
    private String ckgInbunNm;

    @Column(name = "CKG_DODF_NM", length = 50)
    private String ckgDodfNm;

    @Column(name = "CKG_TIME_NM", length = 50)
    private String ckgTimeNm;

    @Column(name = "FIRST_REG_DT", length = 14)
    private String firstRegDt; // CHAR(14) 이므로 String으로 매핑

    @Column(name = "RCP_IMG_URL", columnDefinition = "TEXT")
    private String rcpImgUrl;


    public RecipeDetail() {}
}
