package org.example.backend.impl;

import org.example.backend.Entity.ScannedBarcode;
import org.example.backend.Repository.ScannedBarcodeRepository;
import org.example.backend.Service.ScannedBarcodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScannedBarcodeServiceImpl implements ScannedBarcodeService {

    private final ScannedBarcodeRepository repository;

    public ScannedBarcodeServiceImpl(ScannedBarcodeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ScannedBarcode save(ScannedBarcode barcode) {
        return repository.save(barcode);
    }

    @Override
    public List<ScannedBarcode> getAll() {
        return repository.findAll();
    }
}
