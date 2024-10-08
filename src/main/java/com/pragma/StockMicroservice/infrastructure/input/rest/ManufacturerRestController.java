package com.pragma.StockMicroservice.infrastructure.input.rest;

import com.pragma.StockMicroservice.application.dto.ManufacturerRequest;
import com.pragma.StockMicroservice.application.dto.ManufacturerResponse;
import com.pragma.StockMicroservice.application.handler.IManufacturerHandler;
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
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<Page<ManufacturerResponse>> getAllManufacturers(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam boolean sortDesc) {
        return ResponseEntity.ok(manufacturerHandler.getAllManufacturers(pageIndex, pageSize, sortDesc));
    }
}
