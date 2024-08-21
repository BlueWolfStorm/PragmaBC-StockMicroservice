package com.pragma.StockMicroservice.infrastructure.input.rest;

import com.pragma.StockMicroservice.application.dto.manufacturer.ManufacturerRequest;
import com.pragma.StockMicroservice.application.dto.manufacturer.ManufacturerResponse;
import com.pragma.StockMicroservice.application.handler.manufacturer.IManufacturerHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manufacturer")
@RequiredArgsConstructor
public class ManufacturerRestController {
    private final IManufacturerHandler manufacturerHandler;

    @PostMapping("/")
    public ResponseEntity<Void> createManufacturer(@RequestBody ManufacturerRequest request) {
        manufacturerHandler.insertManufacturer(request);
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("/")
    public ResponseEntity<Page<ManufacturerResponse>> getAllManufacturers(@RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "10") int size,
                                                                          @RequestParam(defaultValue = "true") boolean sortDesc) {
        return ResponseEntity.ok(manufacturerHandler.getAllManufacturers(page, size, sortDesc));
    }
}
