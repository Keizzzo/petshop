package com.ozzziek.petshop.resources;

import com.ozzziek.petshop.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> mostrar(){
        Categoria c1 = new Categoria(1, "Alimento");
        Categoria c2 = new Categoria(2, "Cosmético");
        Categoria c3 = new Categoria(3, "Remédio");

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(c1);
        categorias.add(c2);
        categorias.add(c3);

        return categorias;
    }
}
