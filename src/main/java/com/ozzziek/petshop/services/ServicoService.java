package com.ozzziek.petshop.services;

import com.ozzziek.petshop.domain.Servico;
import com.ozzziek.petshop.repositories.ServicoRepository;
import com.ozzziek.petshop.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
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

}
