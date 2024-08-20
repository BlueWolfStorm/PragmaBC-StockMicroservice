package com.pragma.StockMicroservice.infrastructure.output.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "ARTICLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String description;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;

    @ManyToOne()
    private ManufacturerEntity manufacturer;

    @ManyToMany()
    @JoinTable(name = "ARTICLE_CATEGORY",
            joinColumns = @JoinColumn(name = "ARTICLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    private List<CategoryEntity> categories;
}
