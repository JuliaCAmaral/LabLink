package br.lablink.bean.cliente;

import br.lablink.exception.BusinessException;
import br.lablink.model.dto.cliente.FiltroClienteDTO;
import br.lablink.model.dto.cliente.ResultadoClienteDTO;
import br.lablink.service.ClienteService;
import br.lablink.utils.MessageUtils;
import org.omnifaces.cdi.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named("consultarClienteWebBean")
public class ConsultarClienteWebBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ClienteService service;

    private FiltroClienteDTO filtroDTO = new FiltroClienteDTO();
    private List<ResultadoClienteDTO> clientes;

    public void buscar() {
        try {
            clientes = service.buscarClientes(filtroDTO);
        } catch (BusinessException e) {
            MessageUtils.returnMessageOnFail(e.getErros());
        }
    }

    public FiltroClienteDTO getFiltroDTO() {
        return filtroDTO;
    }

    public void setFiltroDTO(FiltroClienteDTO filtroDTO) {
        this.filtroDTO = filtroDTO;
    }

    public List<ResultadoClienteDTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<ResultadoClienteDTO> clientes) {
        this.clientes = clientes;
    }
}
