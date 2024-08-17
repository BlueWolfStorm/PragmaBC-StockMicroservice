package com.pragma.StockMicroservice.infrastructure.input.rest;

import com.pragma.StockMicroservice.application.dto.ManufacturerRequest;
import com.pragma.StockMicroservice.application.handler.IManufacturerHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturer")
@RequiredArgsConstructor
public class ManufacturerRestController {
    private final IManufacturerHandler manufacturerHandler;

    @PostMapping("/")
    public void createManufacturer(@RequestBody ManufacturerRequest request) {
        manufacturerHandler.insertManufacturer(request);
    }
}
