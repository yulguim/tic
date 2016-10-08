package me.ulguim.tcc.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.k2s.sdk.web.profile.Profile;
import in.k2s.sdk.web.validation.ValidationException;
import me.ulguim.tcc.manager.LoginManager;
import me.ulguim.tcc.view.LoginView;
import me.ulguim.tcc.view.ProfileView;

@RestController
public class LoginController {
	
	@Autowired LoginManager loginManager;
	
	@RequestMapping(value="/admin/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ProfileView login(@RequestBody LoginView view, HttpServletResponse response) throws ValidationException {		
		Profile profile = loginManager.login(view);
		//response.addCookie(createCookie(profile));
		
		ProfileView profileView = new ProfileView();
		//profileView.setUsuario(((UsuarioImagikView) profile.getUsuario()).getName());
		return profileView;
	}

}
