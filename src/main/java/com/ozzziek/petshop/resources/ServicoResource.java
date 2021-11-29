package com.ozzziek.petshop.resources;

import com.ozzziek.petshop.domain.Servico;
import com.ozzziek.petshop.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Servico> insert(@RequestBody Servico obj){

        obj = servicoService.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Servico obj, @PathVariable Integer id){

        obj.setId(id);
        servicoService.update(obj);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        servicoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
