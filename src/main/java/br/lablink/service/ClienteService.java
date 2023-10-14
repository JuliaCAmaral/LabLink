package br.lablink.service;

import br.lablink.model.dto.cliente.CadastroClienteDTO;
import br.lablink.model.dto.cliente.FiltroClienteDTO;
import br.lablink.model.dto.cliente.ResultadoClienteDTO;
import br.lablink.model.entities.Cliente;
import br.lablink.repository.ClienteRepository;
import br.lablink.service.validador.ClienteValidador;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static br.lablink.utils.CpfCnpjUtil.removeFormatacao;

@Stateless
public class ClienteService {

    @Inject
    private ClienteValidador validador;

    @Inject
    private ClienteRepository repository;

    Subject user;

    @PostConstruct
    public void init() {
        user = SecurityUtils.getSubject();
    }

    public CadastroClienteDTO salvarCliente(CadastroClienteDTO clienteDTO) {
        validador.validarSalvar(clienteDTO);

        Cliente cliente;
        if (clienteDTO.getIdCliente() == null) {
            cliente = new Cliente();
        } else {
            cliente = repository.getClienteById(clienteDTO.getIdCliente());
        }

        popularCliente(clienteDTO, cliente);
        persistirCliente(clienteDTO.getIdCliente(), cliente);

        return traduzirClienteDTO(cliente);
    }

    private void persistirCliente(Long idCliente, Cliente cliente) {
        if (idCliente == null) {
            repository.create(cliente);
        } else {
            repository.update(cliente);
        }
        repository.flush();
    }

    private void popularCliente(CadastroClienteDTO clienteDTO, Cliente cliente) {
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());

        if (clienteDTO.isPessoaFisica()) {
            cliente.setCpf(removeFormatacao(clienteDTO.getCpf()));
        } else {
            cliente.setCnpj(removeFormatacao(clienteDTO.getCnpj()));
        }
    }

    public List<ResultadoClienteDTO> buscarClientes(FiltroClienteDTO filtroDTO) {
        validador.validarBusca(filtroDTO);
        List<Object[]> objects = repository.getClientes(filtroDTO);

        return objects
                .stream()
                .map(ResultadoClienteDTO::new)
                .collect(Collectors.toList());
    }

    public CadastroClienteDTO obterClienteByIdCliente(Long idCliente) {
        Cliente cliente = repository.getClienteById(idCliente);
        return traduzirClienteDTO(cliente);
    }

    private CadastroClienteDTO traduzirClienteDTO(Cliente cliente) {
        CadastroClienteDTO clienteDTO = new CadastroClienteDTO();
        clienteDTO.setIdCliente(cliente.getIdCliente());
        clienteDTO.setCnpj(cliente.getCnpj());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setPessoaFisica(cliente.getCpf() != null);
        return clienteDTO;
    }
}
