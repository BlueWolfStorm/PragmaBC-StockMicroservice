package com.pragma.StockMicroservice.infrastructure.input.rest;

import com.pragma.StockMicroservice.application.dto.category.CategoryRequest;
import com.pragma.StockMicroservice.application.dto.category.CategoryResponse;
import com.pragma.StockMicroservice.application.handler.category.ICategoryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestController {
    private final ICategoryHandler categoryHandler;

    @PostMapping("/")
    public ResponseEntity<Void> insertCategory(@RequestBody CategoryRequest categoryRequest) {
        categoryHandler.insertCategory(categoryRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/")
    public ResponseEntity<Page<CategoryResponse>> getAllCategories(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "10") int size,
                                                                   @RequestParam(defaultValue = "true") boolean sortDesc) {
        return ResponseEntity.ok(categoryHandler.getAllCategories(page, size, sortDesc));
    }

}
