package br.lablink.bean.cliente;

import br.lablink.exception.BusinessException;
import br.lablink.model.dto.cliente.CadastroClienteDTO;
import br.lablink.service.ClienteService;
import br.lablink.utils.MessageUtils;
import org.omnifaces.cdi.Param;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named("cadastroClienteWebBean")
public class CadastroClienteWebBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Param(name = "idCliente")
    private Long idCliente;

    @Inject
    private ClienteService service;

    private CadastroClienteDTO clienteDTO;

    @PostConstruct
    public void init() {
        if (idCliente == null) {
            clienteDTO = new CadastroClienteDTO();
        } else {
            clienteDTO = service.obterClienteByIdCliente(idCliente);
        }
    }

    public void salvar() {
        try {
            clienteDTO = service.salvarCliente(clienteDTO);
            if (idCliente == null) {
                MessageUtils.returnGlobalMessageOnSuccess("Salvo com sucesso!");
                Faces.redirect("protected/cliente/cadastrar.xhtml?idCliente=" + clienteDTO.getIdCliente());
            } else {
                MessageUtils.returnMessageOnSuccess("Salvo com sucesso!");
            }

        } catch (BusinessException e) {
            MessageUtils.returnMessageOnFail(e.getErros());

        } catch (Exception e) {
            MessageUtils.returnMessageOnFail("Ocorreu um erro ao salvar. Por favor, entre em contato com o suporte.");
        }
    }

    public boolean isClienteSalvo() {
        return clienteDTO.getIdCliente() != null;
    }

    public CadastroClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void limparCampos() {
        clienteDTO.setCnpj(null);
        clienteDTO.setCpf(null);
    }
}
