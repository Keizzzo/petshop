package com.ozzziek.petshop.services;

import com.ozzziek.petshop.domain.Categoria;
import com.ozzziek.petshop.domain.Pessoa;
import com.ozzziek.petshop.repositories.CategoriaRepository;
import com.ozzziek.petshop.repositories.PessoaRepository;
import com.ozzziek.petshop.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa find(Integer id){
        Optional<Pessoa> obj = pessoaRepository.findById(id);

        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id
                        + ", Tipo: " + Pessoa.class.getName()));
    }

}
