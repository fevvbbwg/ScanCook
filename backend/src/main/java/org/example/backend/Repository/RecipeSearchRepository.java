package org.example.backend.Repository;

import org.example.backend.Entity.RecipeSearch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeSearchRepository extends JpaRepository<RecipeSearch, String> {

    // 검색 (대소문자 무시)
    List<RecipeSearch> findByRcpTtlContainingIgnoreCase(String keyword);

    // 오늘의 레시피 (최근 등록순)
    List<RecipeSearch> findTop5ByOrderByFirstRegDtDesc();

    // 추천 많은 레시피
    List<RecipeSearch> findTop5ByOrderByRcmmCntDesc();

    List<RecipeSearch> findByRcpTtlContainingIgnoreCaseOrCkgNmContainingIgnoreCase(String keyword, String keyword1);
}
