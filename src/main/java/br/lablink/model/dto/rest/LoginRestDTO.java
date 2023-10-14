package br.lablink.model.dto.rest;

import javax.validation.constraints.NotNull;

public class LoginRestDTO {

    @NotNull(message = "Campo Obrigatório: email")
    private String email;

    @NotNull(message = "Campo Obrigatório: senha")
    private String senha;


    public LoginRestDTO() { }

    public LoginRestDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
