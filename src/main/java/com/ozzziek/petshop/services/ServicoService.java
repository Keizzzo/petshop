package com.ozzziek.petshop.services;

import com.ozzziek.petshop.domain.Servico;
import com.ozzziek.petshop.repositories.ServicoRepository;
import com.ozzziek.petshop.services.exceptions.IntegridadeDeDadosException;
import com.ozzziek.petshop.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico find(Integer id){
        Optional<Servico> obj = servicoRepository.findById(id);

        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id
                        + ", Tipo: " + Servico.class.getName()));
    }

    public Servico insert(Servico obj){
        obj.setId(null);
        return servicoRepository.save(obj);
    }

    public Servico update(Servico obj){
        find(obj.getId());
        return servicoRepository.save(obj);
    }

    public void delete(Integer id){
        find(id);
        try {
            servicoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new IntegridadeDeDadosException("Servico nao pode ser deletado!");
        }
    }
}
