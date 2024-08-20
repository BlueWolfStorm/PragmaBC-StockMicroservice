package com.pragma.StockMicroservice.infrastructure.output.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "MANUFACTURER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ManufacturerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 120)
    private String description;
}