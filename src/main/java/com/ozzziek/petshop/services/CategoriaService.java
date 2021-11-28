package com.ozzziek.petshop.services;

import com.ozzziek.petshop.domain.Categoria;
import com.ozzziek.petshop.repositories.CategoriaRepository;
import com.ozzziek.petshop.services.exceptions.IntegridadeDeDadosException;
import com.ozzziek.petshop.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Categoria obj){
        find(obj.getId());
        return categoriaRepository.save(obj);
    }

    public void delete(Integer id){
        find(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new IntegridadeDeDadosException("Categoria já possui produtos. Não é possível apagar!");
        }
    }

}
