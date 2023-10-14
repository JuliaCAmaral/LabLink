package br.lablink.service;

import br.lablink.model.dto.LoginDTO;
import br.lablink.security.UserAuthenticationToken;
import br.lablink.utils.MessageUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.subject.Subject;
import org.omnifaces.util.Faces;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class UsuarioService {

    Subject user;

    @PostConstruct
    public void init() {
        user = SecurityUtils.getSubject();
    }

    public LoginDTO login(LoginDTO loginDTO) {
        user = SecurityUtils.getSubject();
        if (user.isAuthenticated()) {
            Faces.redirect("protected/inicial.xhtml");
            return null;
        }

        String errorMsg = validateFields(loginDTO);

        if (errorMsg == null) {
            UserAuthenticationToken token = new UserAuthenticationToken(loginDTO);
            try {
                user.login(token);
                if (user.isAuthenticated()) {
                    Faces.redirect("protected/inicial.xhtml");
                }
                return loginDTO;
            } catch (IncorrectCredentialsException e) {
                MessageUtils.returnMessageOnFail("Usuário ou senha incorreta");
            } catch (Exception e) {
                MessageUtils.returnMessageOnFail("Ocorreu um erro ao efetuar o login. Por favor, entre em contato com o suporte");
            }
        } else {
            MessageUtils.returnMessageOnFail(errorMsg);
        }
        return loginDTO;
    }

    private String validateFields(LoginDTO loginDto) {
        String message = null;
        if (StringUtils.isBlank(loginDto.getEmail()) && StringUtils.isBlank(loginDto.getSenha())) {
            message = "Por favor, preencha os campos";
        } else if (StringUtils.isBlank(loginDto.getEmail())) {
            message = "E-mail não informado";
        } else if (StringUtils.isBlank(loginDto.getSenha())) {
            message = "Senha não informada";
        }

        return message;
    }
}
