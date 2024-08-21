package com.pragma.StockMicroservice.domain.api;

import com.pragma.StockMicroservice.domain.model.Article;
import org.springframework.data.domain.Page;

public interface IGetArticleServicePort {
    Page<Article> getAllCategories(int page,
                                   int size,
                                   boolean sortDesc,
                                   String articleName,
                                   String articleManufacturer,
                                   String articleArticle);
}
