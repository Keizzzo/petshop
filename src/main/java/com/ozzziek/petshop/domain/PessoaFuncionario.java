package com.ozzziek.petshop.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PessoaFuncionario extends Pessoa{

    private static final long serialVersionUID = 1L;

    private String funcao;

    @OneToMany(mappedBy = "funcionario")
    private List<Servico> servicos = new ArrayList<>();

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

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
