package com.pragma.StockMicroservice.infrastructure.input.rest;


import com.pragma.StockMicroservice.application.dto.article.ArticleRequest;
import com.pragma.StockMicroservice.application.dto.article.ArticleResponse;
import com.pragma.StockMicroservice.application.handler.article.IArticleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleRestController {
    private final IArticleHandler articleHandler;

    @PostMapping("/")
    public ResponseEntity<Void> insertArticle(@RequestBody ArticleRequest articleRequest) {
        articleHandler.insertArticle(articleRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/")
    public ResponseEntity<Page<ArticleResponse>> getArticles(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size,
                                                             @RequestParam(defaultValue = "true") boolean sortDesc,
                                                             @RequestParam(defaultValue = "") String articleName,
                                                             @RequestParam(defaultValue = "") String articleManufacturer,
                                                             @RequestParam(defaultValue = "") String articleCategory) {
        return ResponseEntity.ok(articleHandler.getAllCategories(page, size, sortDesc, articleName, articleManufacturer, articleCategory));
    }
}
