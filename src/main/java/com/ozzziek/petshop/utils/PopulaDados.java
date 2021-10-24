package com.ozzziek.petshop.utils;

import com.ozzziek.petshop.domain.Categoria;
import com.ozzziek.petshop.domain.Produto;
import com.ozzziek.petshop.repositories.CategoriaRepository;
import com.ozzziek.petshop.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Array;
import java.util.Arrays;

@Component
public class PopulaDados {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    //NOTAÇÃO JAVA - executa após build do sistema
    @PostConstruct
    public void cadastrar(){
        Categoria c1 = new Categoria(null, "Alimento");
        Categoria c2 = new Categoria(null, "Cosmético");
        Categoria c3 = new Categoria(null, "Remédio");

        Produto p1 = new Produto(null, "Ração", 100.0);
        Produto p2 = new Produto(null, "Sache", 80.0);
        Produto p3 = new Produto(null, "Shampoo", 50.0);
        Produto p4 = new Produto(null, "Vermífugo", 20.0);

        c1.getProdutos().addAll(Arrays.asList(p1, p2));
        c2.getProdutos().addAll(Arrays.asList(p3, p4));
        c3.getProdutos().add(p4);

        p1.getCategorias().add(c1);
        p2.getCategorias().add(c1);
        p3.getCategorias().add(c2);
        p4.getCategorias().add(c2);
        p4.getCategorias().add(c3);

        categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
    }
}
