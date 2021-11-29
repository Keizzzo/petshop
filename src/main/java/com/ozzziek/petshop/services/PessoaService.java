package com.ozzziek.petshop.services;

import com.ozzziek.petshop.domain.Pessoa;
import com.ozzziek.petshop.repositories.PessoaRepository;
import com.ozzziek.petshop.services.exceptions.IntegridadeDeDadosException;
import com.ozzziek.petshop.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Pessoa insert(Pessoa obj){
        obj.setId(null);
        return pessoaRepository.save(obj);
    }

    public Pessoa update(Pessoa obj){
        find(obj.getId());
        return pessoaRepository.save(obj);
    }

    public void delete(Integer id){
        find(id);
        try {
            pessoaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new IntegridadeDeDadosException("Pessoa não pode ser apagada!");
        }
    }

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }
}
