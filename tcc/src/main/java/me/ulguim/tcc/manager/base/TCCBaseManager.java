package me.ulguim.tcc.manager.base;

import in.k2s.sdk.web.profile.Profile;
import me.ulguim.tcc.entity.Account;

/**
 * Created by yulle on 17/01/17.
 */
public abstract class TCCBaseManager {

	public Account getAccount(Profile profile) {
		return (Account) profile.getUsuario();
	}

}