package org.example.backend.Repository;

import org.example.backend.Entity.RecipeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeDetailRepository extends JpaRepository<RecipeDetail, String> {

    // 랜덤 조회
    @Query(value = "SELECT * FROM recipe ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<RecipeDetail> findRandomRecipes(@Param("count") int count);

    // RCP_SNO(Long)로 조회
    @Query(value = "SELECT * FROM recipe WHERE RCP_SNO = :rcpSno", nativeQuery = true)
    Optional<RecipeDetail> findByRcpSnoNative(@Param("rcpSno") Long rcpSno);

    // 오늘의 레시피 / 페이지네이션용 (랜덤)
    @Query(value = "SELECT * FROM recipe ORDER BY RAND() LIMIT :size OFFSET :offset", nativeQuery = true)
    List<RecipeDetail> findRecipesByPage(@Param("offset") int offset, @Param("size") int size);

    // 인기 레시피: 추천수 기준 내림차순
    @Query(value = "SELECT * FROM recipe ORDER BY RCMM_CNT DESC LIMIT :size OFFSET :offset", nativeQuery = true)
    List<RecipeDetail> findPopularRecipes(@Param("offset") int offset, @Param("size") int size);
}
