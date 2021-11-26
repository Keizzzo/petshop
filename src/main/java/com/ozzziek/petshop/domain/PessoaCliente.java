package com.ozzziek.petshop.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PessoaCliente extends Pessoa{


    private static final long serialVersionUID = 1L;

    private String tipo;

    @OneToMany(mappedBy = "cliente")
    private List<Servico> servicos = new ArrayList<>();

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

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
