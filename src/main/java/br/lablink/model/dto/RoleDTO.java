package br.lablink.model.dto;

import br.lablink.model.entities.Role;

import java.io.Serializable;
import java.util.Objects;

public class RoleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idRole;
    private String nome;

    public RoleDTO() {
    }

    public RoleDTO(Long idRole, String nome) {
        this.idRole = idRole;
        this.nome = nome;
    }

    public RoleDTO(Role role) {
        this.idRole = role.getIdRole();
        this.nome = role.getNome();
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return Objects.equals(idRole, roleDTO.idRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole);
    }
}
