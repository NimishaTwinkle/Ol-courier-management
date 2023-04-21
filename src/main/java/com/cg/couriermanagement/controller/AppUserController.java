package com.cg.couriermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.couriermanagement.entity.AppUserEntity;
import com.cg.couriermanagement.exception.AppUserException;
import com.cg.couriermanagement.exception.InvalidPasswordException;
import com.cg.couriermanagement.model.AppUser;
import com.cg.couriermanagement.service.IAppUserService;

@RestController
@RequestMapping("/appuser")
@CrossOrigin(origins = "http://localhost:3000")
public class AppUserController {
	@Autowired 
    private IAppUserService appUserService;
	
    @PostMapping("/register")
     public AppUserEntity register(@RequestBody AppUser appUser) throws AppUserException{
    	AppUserEntity newAppUserEntity = appUserService.register(appUser);
    	return newAppUserEntity;
     }

    @PostMapping("/login")
    public AppUserEntity login(@RequestParam String userId,@RequestParam String password) throws AppUserException, InvalidPasswordException {
    	AppUserEntity newAppUserEntity = appUserService.login(userId, password);
    	return newAppUserEntity;
	}
}
