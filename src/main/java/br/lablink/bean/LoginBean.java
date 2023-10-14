package br.lablink.bean;

import br.lablink.model.dto.LoginDTO;
import br.lablink.service.UsuarioService;
import br.lablink.utils.MessageUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named("loginBean")
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioService usuarioService;

    private LoginDTO login = new LoginDTO();

    @PostConstruct
    public void init() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            Faces.redirect("protected/inicial.xhtml");
        }
    }

    public void entrar() {
        try {
            login = usuarioService.login(login);
        } catch (Exception e) {
            MessageUtils.returnMessageOnFail("Ocorreu um erro no login.");
        }
    }

    public String logout() {
        try {
            Subject user = SecurityUtils.getSubject();
            if (user != null) {
                user.logout();
            }
            return "protected/inicial.xhtml?faces-redirect=true";
        } catch (Exception e) {
            MessageUtils.returnMessageOnFail("Ocorreu um erro no logout.");
            return null;
        }
    }

    public LoginDTO getLogin() {
        return login;
    }
}
