package br.lablink.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoginDTO implements Serializable {

    private static final long serialVersionUID = 505864841350030607L;

    private Long idUsuario;
    private String email;
    private String senha;

    List<RoleDTO> roles = new ArrayList<>();

    public LoginDTO() {
    }

    public LoginDTO(Long idUsuario, String email, String senha) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(idUsuario, loginDTO.idUsuario) && Objects.equals(email, loginDTO.email) && Objects.equals(senha, loginDTO.senha) && Objects.equals(roles, loginDTO.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, email, senha, roles);
    }
}
