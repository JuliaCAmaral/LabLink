package br.lablink.model.entities.enums;

public enum TipoPessoaEnum {
    FISICA   ("Física"),
    JURIDICA("Jurídica");

    private String valor;

    TipoPessoaEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
