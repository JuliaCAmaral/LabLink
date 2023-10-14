package br.lablink.repository;

import br.lablink.model.dto.LoginDTO;
import br.lablink.model.dto.RoleDTO;
import br.lablink.model.entities.Usuario;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository extends GenericRepository<Usuario> {

    public UsuarioRepository() {
        super(Usuario.class);
    }

    public LoginDTO login(LoginDTO loginDto) {
        try {
            return entityManager.createNamedQuery(Usuario.GET_LOGINDTO_BY_EMAIL, LoginDTO.class)
                    .setParameter("email", loginDto.getEmail())
                    .getSingleResult();
        } catch (NoResultException e) {
            return loginDto;
        }
    }

    public List<RoleDTO> consultarRolesPorIdUsuario(Long idUsuario) {
        if (idUsuario == null) {
            return new ArrayList<>();
        }

        return entityManager.createQuery("SELECT new br.lablink.model.dto.RoleDTO(r.id, r.nome) " +
                        "FROM Usuario u " +
                        "JOIN u.roles r " +
                        "WHERE u.id = :idUsuario", RoleDTO.class)
                .setParameter("idUsuario", idUsuario)
                .getResultList();
    }
}
