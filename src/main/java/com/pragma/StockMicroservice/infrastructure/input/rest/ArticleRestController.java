package com.pragma.StockMicroservice.infrastructure.input.rest;


import com.pragma.StockMicroservice.application.dto.ArticleRequest;
import com.pragma.StockMicroservice.application.handler.IArticleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleRestController {
    private final IArticleHandler articleHandler;

    @PostMapping("/")
    public ResponseEntity<Void> insertArticle(@RequestBody ArticleRequest articleRequest) {
        articleHandler.insertArticle(articleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
