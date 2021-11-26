package com.ozzziek.petshop.utils;

import com.ozzziek.petshop.domain.*;
import com.ozzziek.petshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Component
public class PopulaDados {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EspecieRepository especieRepository;

    @Autowired
    RacaRepository racaRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

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

        Especie e1 = new Especie(null, "Cachorro");
        Especie e2 = new Especie(null, "Gato");

        Raca r1 = new Raca(null, "Akita");
        Raca r2 = new Raca(null, "Shitzu");
        Raca r3 = new Raca(null, "Persa");

        Pet pet1 = new Pet(null, "John", 6, e1,r2);
        Pet pet2 = new Pet(null, "Hana", 5, e1,r1);
        Pet pet3 = new Pet(null, "Mewth", 8, e2,r3);

        especieRepository.saveAll(Arrays.asList(e1, e2));
        racaRepository.saveAll(Arrays.asList(r1,r2,r3));
        petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));

        Estado es1 = new Estado(null, "São Paulo");
        Estado es2 = new Estado(null, "Minas Gerais");

        Cidade cid1 = new Cidade(null, "Belo Horizonte", es2);
        Cidade cid2 = new Cidade(null, "Capelinha", es2);
        Cidade cid3 = new Cidade(null, "Santo André", es1);

        es1.getCidades().addAll(Arrays.asList(cid3));
        es2.getCidades().addAll(Arrays.asList(cid1, cid2));

        estadoRepository.saveAll(Arrays.asList(es1, es2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        PessoaCliente pc = new PessoaCliente(null,
                "John Wick",
                "jw@continental",
                "39402850805",
                "Fisica");
        pc.getTelefones().addAll(Arrays.asList("+5511992413986","+5519997043466"));

        PessoaFuncionario pf = new PessoaFuncionario(null,
                "Winston",
                "manager@continental",
                "11111111111",
                "Gerente");
        pf.getTelefones().addAll(List.of("+01111111"));

        Endereco jw1 = new Endereco(null,
                "Maringa",
                "131",
                "NA",
                "Vila Helena",
                "09175440",
                cid1,
                pc);

        Endereco jw2 = new Endereco(null,
                "Espirito Santo",
                "215",
                "Hotel Nacional INN",
                "Centro",
                "30160030",
                cid3,
                pc);

        Endereco win = new Endereco(null,
                "Espirito Santo",
                "215",
                "Hotel Nacional INN",
                "Centro",
                "30160030",
                cid3,
                pf);

        //Polimorfismo Cliente e Funcionario
        pessoaRepository.saveAll(Arrays.asList(pc, pf));

        enderecoRepository.saveAll(Arrays.asList(jw1, jw2, win));

    }
}
