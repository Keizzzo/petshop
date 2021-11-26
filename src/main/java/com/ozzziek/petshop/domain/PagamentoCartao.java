package com.ozzziek.petshop.domain;

import com.ozzziek.petshop.domain.enums.SituacaoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento{

    private Integer parcelas;

    public PagamentoCartao(){}

    public PagamentoCartao(Integer id,
                           Double valor,
                           SituacaoPagamento situacao,
                           Servico servico,
                           Integer parcelas) {
        super(id, valor, situacao, servico);
        this.parcelas = parcelas;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }
}
