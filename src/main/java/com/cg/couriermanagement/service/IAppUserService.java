package com.cg.couriermanagement.service;

import com.cg.couriermanagement.entity.AppUserEntity;
import com.cg.couriermanagement.exception.AppUserException;
import com.cg.couriermanagement.exception.InvalidPasswordException;
import com.cg.couriermanagement.model.AppUser;

public interface IAppUserService {

	public AppUserEntity register(AppUser appUser) throws AppUserException;
	public AppUserEntity login(String userId, String password)throws AppUserException, InvalidPasswordException;
	
}
