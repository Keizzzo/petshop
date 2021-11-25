package com.ozzziek.petshop.domain.enums;

public enum SituacaoPagamento {
    QUITADO(1, "Quitado"),
    CANCELADO(2, "Cancelado"),
    PENDENTE(3, "Pendente");

    private int codigo;
    private String status;

    SituacaoPagamento(int codigo, String status) {
        this.codigo = codigo;
        this.status = status;
    }

    public static SituacaoPagamento toEnum(Integer codigo) {
        if(codigo == null){
            return null;
        }

        for(SituacaoPagamento s:SituacaoPagamento.values()){
            if(codigo.equals(s.getCodigo())){
                return s;
            }
        }

        throw new IllegalArgumentException();

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
