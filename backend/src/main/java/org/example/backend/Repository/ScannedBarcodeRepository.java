package org.example.backend.Repository;

import org.example.backend.Entity.ScannedBarcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScannedBarcodeRepository extends JpaRepository<ScannedBarcode, Long> {
    // 필요하면 사용자별 검색 메서드 추가 가능
}
