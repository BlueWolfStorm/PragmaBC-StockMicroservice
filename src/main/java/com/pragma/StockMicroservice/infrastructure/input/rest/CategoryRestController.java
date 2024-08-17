package com.pragma.StockMicroservice.infrastructure.input.rest;

import com.pragma.StockMicroservice.application.dto.CategoryRequest;
import com.pragma.StockMicroservice.application.dto.CategoryResponse;
import com.pragma.StockMicroservice.application.handler.ICategoryHandler;
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
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<Page<CategoryResponse>> getAllCategories(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam boolean sortDesc) {
        return ResponseEntity.ok(categoryHandler.getAllCategories(pageIndex, pageSize, sortDesc));
    }

}
