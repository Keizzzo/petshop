package com.ozzziek.petshop.services;

import com.ozzziek.petshop.domain.Categoria;
import com.ozzziek.petshop.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);

        return obj.orElse(null);
    }

}
