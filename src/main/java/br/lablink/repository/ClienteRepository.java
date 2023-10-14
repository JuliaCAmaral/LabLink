package br.lablink.repository;

import br.lablink.exception.EntityNotFoundException;
import br.lablink.model.dto.cliente.FiltroClienteDTO;
import br.lablink.model.entities.Cliente;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static br.lablink.utils.CpfCnpjUtil.removeFormatacao;

public class ClienteRepository extends GenericRepository<Cliente> {

    public List<Object[]> getClientes(FiltroClienteDTO filtroDTO) {
        String sql = sqlGetClientes(filtroDTO);

        try {
            Query query = entityManager.createNativeQuery(sql);

            if (filtroDTO.getNome() != null && !filtroDTO.getNome().isBlank()) {
                query.setParameter("nome", "%" + filtroDTO.getNome().toLowerCase() + "%");
            }

            if (filtroDTO.getDocumento() != null && !filtroDTO.getDocumento().isBlank()) {
                query.setParameter("documento", "%" + removeFormatacao(filtroDTO.getDocumento()) + "%");
            }

            return query.getResultList();

        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }

    private String sqlGetClientes(FiltroClienteDTO filtroDTO) {
        String sql = "SELECT ID_CLIENTE, NOME, COALESCE(CPF,CNPJ), " +
                "CASE  " +
                "WHEN CPF IS NULL THEN FALSE " +
                "ELSE TRUE " +
                "END " +
                "FROM CLIENTE " +
                "WHERE ";

        if (filtroDTO.getNome() != null) {
            sql = sql + "LOWER(nome) ilike :nome ";
        }

        if (filtroDTO.getDocumento() != null) {
            sql = sql + "cpf ilike :documento OR cnpj ilike :documento";
        }

        return sql;
    }

    public Cliente getClienteById(Long idCliente) {
        Cliente cliente = entityManager.find(Cliente.class, idCliente);

        if (cliente == null)
            throw new EntityNotFoundException("Cliente", idCliente.toString());

        return cliente;
    }
}
