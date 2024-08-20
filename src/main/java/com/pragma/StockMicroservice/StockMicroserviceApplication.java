package com.pragma.StockMicroservice;

import org.babyfish.jimmer.spring.repository.EnableJimmerRepositories;
import org.babyfish.jimmer.sql.meta.DatabaseNamingStrategy;
import org.babyfish.jimmer.sql.runtime.DefaultDatabaseNamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableJimmerRepositories
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class StockMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockMicroserviceApplication.class, args);
    }

    @Bean
    public DatabaseNamingStrategy databaseNamingStrategy() {
        return DefaultDatabaseNamingStrategy.UPPER_CASE;
    }
}
