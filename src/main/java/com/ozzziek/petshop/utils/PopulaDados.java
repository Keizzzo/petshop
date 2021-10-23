package com.ozzziek.petshop.utils;

import com.ozzziek.petshop.domain.Categoria;
import com.ozzziek.petshop.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class PopulaDados {

    @Autowired
    CategoriaRepository categoriaRepository;

    //NOTAÇÃO JAVA - executa após build do sistema
    @PostConstruct
    public void cadastrar(){
        Categoria c1 = new Categoria(null, "Alimento");
        Categoria c2 = new Categoria(null, "Cosmético");
        Categoria c3 = new Categoria(null, "Remédio");

        categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}
