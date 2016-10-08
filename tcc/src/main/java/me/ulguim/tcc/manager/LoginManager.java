package me.ulguim.tcc.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.k2s.sdk.web.message.Message;
import in.k2s.sdk.web.profile.Profile;
import in.k2s.sdk.web.profile.ProfileBean;
import in.k2s.sdk.web.validation.ValidationException;
import me.ulguim.tcc.entity.Account;
import me.ulguim.tcc.service.LoginService;
import me.ulguim.tcc.view.LoginView;

@Component
public class LoginManager {
	
	@Autowired LoginService loginService;
	
	public Profile login(LoginView view) throws ValidationException {
		if (view == null || view.getLogin() == null || view.getPassword() == null) {
			throw new ValidationException(new Message("message.warn.auth"));
		}
		
		Account entity = loginService.selectByEmailAndPassword(view.getLogin(), view.getPassword());
		if (entity == null) {
			throw new ValidationException(new Message("message.warn.auth"));
		}

		Profile profile = new ProfileBean();
		profile.setUsuario(entity);
		
		return profile;
	}

}
