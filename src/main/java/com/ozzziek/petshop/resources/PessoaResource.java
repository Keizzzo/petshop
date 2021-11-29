package com.ozzziek.petshop.resources;

import com.ozzziek.petshop.domain.Pessoa;
import com.ozzziek.petshop.domain.PessoaCliente;
import com.ozzziek.petshop.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pessoa> insert(@RequestBody PessoaCliente obj){

        Pessoa p = pessoaService.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody PessoaCliente obj, @PathVariable Integer id){

        obj.setId(id);
        pessoaService.update(obj);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        pessoaService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> findAll(){

        List<Pessoa> obj = pessoaService.findAll();

        return ResponseEntity.ok().body(obj);
    }
}
