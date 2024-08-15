package com.pragma.StockMicroservice.structure;

import com.pragma.StockMicroservice.application.CategoriaService;
import com.pragma.StockMicroservice.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController()
@RequestMapping("/v1/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/create")
    public Categoria createCategoria(@RequestBody Categoria categoria){
        return categoriaService.create(categoria);
    }
}
