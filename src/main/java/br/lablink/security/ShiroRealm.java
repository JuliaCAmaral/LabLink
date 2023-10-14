package br.lablink.security;

import br.lablink.model.dto.LoginDTO;
import br.lablink.repository.UsuarioRepository;
import br.lablink.utils.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.SimpleAccountRealm;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class ShiroRealm extends SimpleAccountRealm {

    @Inject
    private UsuarioRepository usuarioRepository;

    public ShiroRealm() {
        setName("loginDTO");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UserAuthenticationToken authToken = (UserAuthenticationToken) token;
        LoginDTO loginDTO = usuarioRepository.login(authToken.getLoginDTO());

        if (loginDTO.getIdUsuario() != null && StringUtils.validatePassword(loginDTO.getSenha(), authToken.getLoginDTO().getSenha())) {
            Map<String, String> credentials = new HashMap<>();
            credentials.put("email", loginDTO.getEmail());
            credentials.put("senha", loginDTO.getSenha());

            authToken.getLoginDTO().setSenha(loginDTO.getSenha());
            authToken.getLoginDTO().setRoles(usuarioRepository.consultarRolesPorIdUsuario(loginDTO.getIdUsuario()));

            return new SimpleAuthenticationInfo(authToken.getLoginDTO(), credentials, ShiroRealm.class.getName());
        } else {
            throw new IncorrectCredentialsException();
        }
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return UserAuthenticationToken.class.equals(token.getClass());
    }
}