package com.pragma.StockMicroservice.infrastructure.output.jimmer.repository;

import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.ManufacturerEntity;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.ManufacturerEntityTable;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.Tables;
import org.babyfish.jimmer.spring.repository.JRepository;
import org.babyfish.jimmer.spring.repository.support.SpringPageFactory;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IManufacturerRepository extends JRepository<ManufacturerEntity, Long> {
    Optional<ManufacturerEntity> findByName(String name);
    ManufacturerEntityTable table = Tables.MANUFACTURER_ENTITY_TABLE;

    default Page<ManufacturerEntity> findAllOrderByNameAsc(int pageIndex, int pageSize){
        return sql()
                .createQuery(table)
                .orderBy(table.name().asc())
                .select(table)
                .fetchPage(pageIndex, pageSize, SpringPageFactory.getInstance());
    }

    default Page<ManufacturerEntity> findAllOrderByNameDesc(int pageIndex, int pageSize){
        return sql()
                .createQuery(table)
                .orderBy(table.name().desc())
                .select(table)
                .fetchPage(pageIndex, pageSize, SpringPageFactory.getInstance());
    }
}
