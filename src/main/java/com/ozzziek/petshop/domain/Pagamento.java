package com.ozzziek.petshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ozzziek.petshop.domain.enums.SituacaoPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private Double valor;
    private Integer situacao;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_servico")
    @MapsId
    private Servico servico;

    public Pagamento(){};

    public Pagamento(Integer id, Double valor, SituacaoPagamento situacao, Servico servico) {
        this.id = id;
        this.valor = valor;
        this.situacao = situacao.getCodigo();
        this.servico = servico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public SituacaoPagamento getSituacao() {
        return SituacaoPagamento.toEnum(situacao);
    }

    public void setSituacao(SituacaoPagamento situacao) {
        this.situacao = situacao.getCodigo();
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
