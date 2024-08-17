package com.pragma.StockMicroservice.infrastructure.output.jimmer.repository;

import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.CategoryEntity;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.CategoryEntityTable;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.Tables;
import org.babyfish.jimmer.spring.repository.JRepository;
import org.babyfish.jimmer.spring.repository.support.SpringPageFactory;
import org.springframework.data.domain.Page;

import java.util.Optional;


public interface ICategoryRepository extends JRepository<CategoryEntity, Long> {
    CategoryEntityTable table = Tables.CATEGORY_ENTITY_TABLE;

    Optional<CategoryEntity> findByName(String name);

    default Page<CategoryEntity> findAllOrderByName(int pageIndex, int pageSize){
        return sql()
                .createQuery(table)
                .orderBy(table.name().asc())
                .select(table)
                .fetchPage(pageIndex, pageSize, SpringPageFactory.getInstance());
    }

    default Page<CategoryEntity> findAllOrderByNameDesc(int pageIndex, int pageSize){
        return sql()
                .createQuery(table)
                .orderBy(table.name().desc())
                .select(table)
                .fetchPage(pageIndex, pageSize, SpringPageFactory.getInstance());
    }
}
