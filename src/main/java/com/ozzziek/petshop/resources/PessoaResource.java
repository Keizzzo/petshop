package com.ozzziek.petshop.resources;

import com.ozzziek.petshop.domain.Categoria;
import com.ozzziek.petshop.domain.Pessoa;
import com.ozzziek.petshop.services.CategoriaService;
import com.ozzziek.petshop.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> find(@PathVariable Integer id){

        Pessoa obj = pessoaService.find(id);

        return ResponseEntity.ok().body(obj);
    }
}
