package com.example.deliveryproviderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.deliveryproviderservice.model.Provider;
import com.example.deliveryproviderservice.repository.ProviderRepository;

@Service
public class ProviderService {

	@Autowired
    private ProviderRepository providerRepository;

    public Provider save(@Validated Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider findById(Integer id){
        return providerRepository.findOne(id);
    }

    public Iterable<Provider> findAll(){
        return providerRepository.findAll();
    }

    public void delete(Integer id) {
    	providerRepository.delete(id);
    }
}
