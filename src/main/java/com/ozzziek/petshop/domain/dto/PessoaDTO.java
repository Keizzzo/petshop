package com.ozzziek.petshop.domain.dto;

import com.ozzziek.petshop.domain.Pessoa;

import java.io.Serializable;

public class PessoaDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String cpfCnpj;

    public PessoaDTO(){}

    public PessoaDTO(Pessoa pessoa){
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.cpfCnpj = pessoa.getCpfCnpj();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}
