package br.lablink.service.validador;

import br.lablink.exception.BusinessException;
import br.lablink.model.dto.cliente.CadastroClienteDTO;
import br.lablink.model.dto.cliente.FiltroClienteDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteValidador {

    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,10}$", Pattern.CASE_INSENSITIVE);


    public void validarSalvar(CadastroClienteDTO dto) throws BusinessException {
        List<String> erros = new ArrayList<>();

        if (dto.getNome() == null || StringUtils.isBlank(dto.getNome()))
            erros.add("Nome é inválido.");

        if (dto.isPessoaFisica()) {
            if (dto.getCpf() == null || StringUtils.isBlank(dto.getCpf()))
                erros.add("CPF é inválido.");
        } else {
            if (dto.getCnpj() == null || StringUtils.isBlank(dto.getCnpj()))
                erros.add("CNPJ é inválido.");
        }

        if (dto.getEmail() == null || StringUtils.isBlank(dto.getEmail())) {
            erros.add("Email é inválido.");
        } else {
            Matcher emailMatcher = EMAIL_REGEX.matcher(dto.getEmail());
            if(!emailMatcher.find())
                erros.add("Email inválido.");
        }

        if (!erros.isEmpty())
            throw new BusinessException(erros);
    }

    public void validarBusca(FiltroClienteDTO filtroDTO) {
        boolean nomeEmBranco = filtroDTO.getNome() == null || filtroDTO.getNome().isBlank();
        boolean documentoEmBranco = filtroDTO.getDocumento() == null || filtroDTO.getDocumento().isBlank();

        if (nomeEmBranco && documentoEmBranco) {
            throw new BusinessException("É necessário preencher ao menos um filtro.");
        }
    }
}
