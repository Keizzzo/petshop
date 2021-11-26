package com.ozzziek.petshop.domain;

import javax.persistence.Entity;

@Entity
public class PessoaFuncionario extends Pessoa{

    private static final long serialVersionUID = 1L;

    private String funcao;

    public PessoaFuncionario() {}

    public PessoaFuncionario(Integer id,
                             String nome,
                             String email,
                             String cpfCnpj,
                             String funcao) {
        super(id, nome, email, cpfCnpj);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
