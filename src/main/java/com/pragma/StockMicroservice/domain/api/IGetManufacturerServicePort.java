package com.pragma.StockMicroservice.domain.api;

import com.pragma.StockMicroservice.domain.model.Manufacturer;
import org.springframework.data.domain.Page;

public interface IGetManufacturerServicePort {
    Page<Manufacturer> getAllCategories(int page,
                                        int size,
                                        boolean sortDesc);
}
