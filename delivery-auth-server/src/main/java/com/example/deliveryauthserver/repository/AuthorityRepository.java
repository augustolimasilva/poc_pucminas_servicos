package com.example.deliveryauthserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deliveryauthserver.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
	Authority findByName(String name);
}