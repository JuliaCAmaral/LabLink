package br.lablink.model.dto.cliente;

import br.lablink.model.entities.enums.TipoPessoaEnum;
import br.lablink.utils.CpfCnpjUtil;

import java.io.Serializable;
import java.math.BigInteger;

public class ResultadoClienteDTO implements Serializable {

    private Long idCliente;
    private String nome;
    private String tipo;
    private String documento;

    public ResultadoClienteDTO(Object[] objects) {
        this.idCliente = ((BigInteger) objects[0]).longValue();
        this.nome = (String) objects[1];
        this.documento = CpfCnpjUtil.formatar((String) objects[2]);
        this.tipo = (boolean) objects[3] ? TipoPessoaEnum.FISICA.getValor() : TipoPessoaEnum.JURIDICA.getValor();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
