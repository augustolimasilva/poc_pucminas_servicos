package com.example.deliveryauthserver.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.deliveryauthserver.model.Authority;
import com.example.deliveryauthserver.model.User;
import com.example.deliveryauthserver.repository.AuthorityRepository;
import com.example.deliveryauthserver.repository.UserRepository;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
	
	UserRepository userRepository;
	
	AuthorityRepository authorityRepository;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
								.map(user -> new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user)))
								.orElseThrow(() -> new UsernameNotFoundException("Usuário "+username+" não encontrado."));
	}
	
	public Optional<User> userExists(String username) {
		return userRepository.findByUsername(username);
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setAuthorityRepository(AuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}
	
	private Collection<GrantedAuthority> getGrantedAuthorities(User user){
    	Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : user.getAuthorities()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }
        return grantedAuthorities;
    }
	
	public String save(@Validated User user) {
		Optional<User> userExists = userExists(user.getUsername());
		
		if(userExists.isPresent()) {
			return "O usuário informado já esta cadastrado.";
		}else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActivated(true);
			Authority userFunction = authorityRepository.findByName("ROLE_ADMIN");
			user.setAuthorities(new HashSet<Authority>(Arrays.asList(userFunction)));
			
			try {
				userRepository.save(user);
				return "Usuário salvo com sucesso.";
			}catch(Exception e) {
				return "Erro ao tentar salvar o usuário. Tente novamente.";
			}
		}
    }
}