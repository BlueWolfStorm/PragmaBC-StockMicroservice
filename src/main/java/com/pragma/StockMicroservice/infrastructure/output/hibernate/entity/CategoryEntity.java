package com.pragma.StockMicroservice.infrastructure.output.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "CATEGORY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 90)
    private String description;
}