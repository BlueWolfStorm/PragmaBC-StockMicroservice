package com.pragma.StockMicroservice.application;

import com.pragma.StockMicroservice.domain.Categoria;
import com.pragma.StockMicroservice.domain.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    private final String NAME_CANNOT_BE_BLANK = "Name cannot be blank";
    private final String NAME_MAX_EXCEDEED = "Max name excedeed";
    private final String DESCRIPTION_CANNOT_BE_BLANK = "Description cannot be blank";
    private final String DESCRIPTION_MAX_EXCEDEED = "Max description exceeded";
    private final String CATEGORY_ALREADY_EXISTS = "Category already exists";


    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Categoria create(Categoria categoria) {
        if(isNotOnDescriptionSize(categoria) || isNotOnNameSize(categoria))
            return null;
        try {
            return categoriaRepository.insert(categoria);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, CATEGORY_ALREADY_EXISTS);
        }
    }

    @Transactional
    public Categoria update(Categoria categoria) {
        if(isNotOnDescriptionSize(categoria) || isNotOnNameSize(categoria))
            return null;
        try {
            return categoriaRepository.update(categoria);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, CATEGORY_ALREADY_EXISTS);
        }
    }

    private boolean isNotOnNameSize(Categoria categoria) {
        if(categoria.nombre().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, NAME_CANNOT_BE_BLANK);

        else if(categoria.nombre().length() > 50)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, NAME_MAX_EXCEDEED);

        else
            return false;
    }

    private boolean isNotOnDescriptionSize(Categoria categoria) {
        if(categoria.descripcion().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, DESCRIPTION_CANNOT_BE_BLANK);
        else if(categoria.descripcion().length() > 90)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, DESCRIPTION_MAX_EXCEDEED);
        else
            return false;
    }
}
