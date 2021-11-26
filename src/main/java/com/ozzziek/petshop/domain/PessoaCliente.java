package com.ozzziek.petshop.domain;

import javax.persistence.Entity;

@Entity
public class PessoaCliente extends Pessoa{


    private static final long serialVersionUID = 1L;

    private String tipo;

    public PessoaCliente() {}

    public PessoaCliente(Integer id,
                             String nome,
                             String email,
                             String cpfCnpj,
                             String tipo) {
        super(id, nome, email, cpfCnpj);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
