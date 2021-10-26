package com.ozzziek.petshop.services;

import com.ozzziek.petshop.domain.Categoria;
import com.ozzziek.petshop.repositories.CategoriaRepository;
import com.ozzziek.petshop.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);

        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id
                        + ", Tipo: " + Categoria.class.getName()));
    }

}
