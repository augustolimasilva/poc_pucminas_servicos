package com.example.deliveryauthserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.deliveryauthserver.model.ResponseModel;
import com.example.deliveryauthserver.model.User;
import com.example.deliveryauthserver.service.UserDetailsService;


@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
	
	@Autowired
	UserDetailsService userDetailsService;

    @RequestMapping("/user")
    public Principal getCurrentLoggedInUser(Principal user) {
        return user;
    }
    
    @RequestMapping(value = "oauth/register", method = RequestMethod.POST)
    public @ResponseBody ResponseModel save(@RequestBody User user){
    	try {
    		String retorno = userDetailsService.save(user);
    		
    		return new ResponseModel(1,retorno);
    	}catch(Exception e) {
    		return new ResponseModel(0, "Ocorreu um erro ao tentar salvar o usuário. Tente novamente.");	
    	}
    }
}