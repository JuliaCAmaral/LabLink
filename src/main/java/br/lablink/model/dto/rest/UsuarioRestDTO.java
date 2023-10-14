package br.lablink.model.dto.rest;

import br.lablink.model.dto.RoleDTO;
import br.lablink.model.dto.UsuarioDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UsuarioRestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idUsuario;
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    public UsuarioRestDTO(UsuarioDTO usuarioDTO) {
        this.idUsuario = usuarioDTO.getIdUsuario();
        this.nome = usuarioDTO.getNome();
        this.cpf = usuarioDTO.getCpf();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
    }

    public UsuarioRestDTO() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UsuarioRestDTO that = (UsuarioRestDTO) o;
        return idUsuario.equals(that.idUsuario);
    }

    @Override public int hashCode() {
        return Objects.hash(idUsuario);
    }
}
