package br.lablink.model.dto.cliente;

import br.lablink.utils.CpfCnpjUtil;

import java.io.Serializable;

public class CadastroClienteDTO implements Serializable {

    private Long idCliente;
    private boolean isPessoaFisica;
    private String nome;
    private String cpf;
    private String cnpj;
    private String email;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isPessoaFisica() {
        return isPessoaFisica;
    }

    public void setPessoaFisica(boolean pessoaFisica) {
        isPessoaFisica = pessoaFisica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return CpfCnpjUtil.formatar(cpf);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return CpfCnpjUtil.formatar(cnpj);
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
