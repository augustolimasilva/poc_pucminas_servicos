package com.example.deliveryproviderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.deliveryproviderservice.model.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
	
	@Query("select nome, cnpj, email, estado from Provider")
	Iterable<Provider> findAllProviders();
}
