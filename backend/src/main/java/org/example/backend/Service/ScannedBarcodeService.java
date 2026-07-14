package org.example.backend.Service;

import org.example.backend.Entity.ScannedBarcode;
import java.util.List;

public interface ScannedBarcodeService {
    ScannedBarcode save(ScannedBarcode barcode);
    List<ScannedBarcode> getAll();
}
