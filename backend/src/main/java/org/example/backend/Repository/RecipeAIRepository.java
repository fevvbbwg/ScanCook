package org.example.backend.Repository;

import org.example.backend.Entity.RecipeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeAIRepository extends JpaRepository<RecipeDetail, Long> {

    // 특정 키워드(재료명 등)가 포함된 레시피 검색
    @Query("SELECT r FROM RecipeDetail r WHERE r.ckgMtrlCn LIKE CONCAT('%', :keyword, '%')")
    List<RecipeDetail> findByIngredientKeyword(String keyword);


    // 인기순, 추천순, 최신순 정렬 등도 필요하면 추가 가능
    @Query(value = "SELECT * FROM recipe ORDER BY INQ_CNT DESC LIMIT 20", nativeQuery = true)
    List<RecipeDetail> findTopPopularRecipes();
}
