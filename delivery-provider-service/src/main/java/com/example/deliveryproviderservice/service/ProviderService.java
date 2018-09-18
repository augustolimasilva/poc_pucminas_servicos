package com.example.deliveryproviderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.deliveryproviderservice.model.Provider;
import com.example.deliveryproviderservice.repository.ProviderRepository;

@Service
public class ProviderService {

	@Autowired
    private ProviderRepository providerRepository;

	@Cacheable("salvarFornecedor")
    public Provider save(@Validated Provider provider) {
        return providerRepository.save(provider);
    }
	@Cacheable("pesquisarPorId")
    public Provider findById(Integer id){
        return providerRepository.findOne(id);
    }

	@Cacheable("pesquisarTodosFornecedores")
    public Iterable<Provider> findAll(){
        return providerRepository.findAll();
    }

	@Cacheable("excluirFornecedor")
    public void delete(Integer id) {
    	providerRepository.delete(id);
    }
	
	@Cacheable("pesquisarTdFornecedores")
	public Iterable<Provider> findAllPvd(){
		return providerRepository.findAllProviders();
	}
}
