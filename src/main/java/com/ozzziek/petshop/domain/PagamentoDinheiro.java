package com.ozzziek.petshop.domain;

import com.ozzziek.petshop.domain.enums.SituacaoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoDinheiro extends Pagamento{

    private Date dataPagamento;
    private Double desconto;

    public PagamentoDinheiro(){}

    public PagamentoDinheiro(Integer id,
                             Double valor,
                             SituacaoPagamento situacao,
                             Servico servico,
                             Date dataPagamento,
                             Double desconto) {
        super(id, valor, situacao, servico);
        this.dataPagamento = dataPagamento;
        this.desconto = desconto;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
}
