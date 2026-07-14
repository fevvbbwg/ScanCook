package org.example.backend.Controller;


import org.example.backend.Entity.ScannedBarcode;
import org.example.backend.Service.ScannedBarcodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barcodes")
public class ScannedBarcodeController {

    private final ScannedBarcodeService service;

    public ScannedBarcodeController(ScannedBarcodeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ScannedBarcode> saveBarcode(@RequestBody ScannedBarcode barcode) {
        return ResponseEntity.ok(service.save(barcode));
    }

    @GetMapping
    public ResponseEntity<List<ScannedBarcode>> getAllBarcodes() {
        return ResponseEntity.ok(service.getAll());
    }
}
