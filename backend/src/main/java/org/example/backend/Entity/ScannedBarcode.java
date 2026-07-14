package org.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Entity
public class ScannedBarcode {

    // Getter & Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String barcodeValue;

    private LocalDateTime scannedAt;

    @Setter
    private String userID;

    @PrePersist
    protected void onCreate() {
        this.scannedAt = LocalDateTime.now();
    }

    // 기본 생성자
    public ScannedBarcode() {}

    // 필요하면 생성자
    public ScannedBarcode(String barcodeValue, String userID) {
        this.barcodeValue = barcodeValue;
        this.userID = userID;
    }

}
