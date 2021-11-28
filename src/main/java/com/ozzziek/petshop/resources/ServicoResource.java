package com.ozzziek.petshop.resources;

import com.ozzziek.petshop.domain.Servico;
import com.ozzziek.petshop.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Servico> find(@PathVariable Integer id){

        Servico obj = servicoService.find(id);

        return ResponseEntity.ok().body(obj);
    }
}
