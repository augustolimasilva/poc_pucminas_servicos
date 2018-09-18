package com.example.deliveryproviderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.deliveryproviderservice.model.Provider;
import com.example.deliveryproviderservice.model.ResponseModel;
import com.example.deliveryproviderservice.service.ProviderService;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProviderController {
	
	@Autowired
    private ProviderService providerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseModel save(@RequestBody  Provider provider){
    	try {
    		providerService.save(provider);
    		return new ResponseModel(1, "Fornecedor cadastrado com sucesso.");
    	}catch (Exception e){
    		return new ResponseModel(2, "Erro ao tentar cadastrar o fornecedor. Verifique os dados e tente novamente.");
    	}
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Provider> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(providerService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Provider>> findAll(){
        return ResponseEntity.ok().body(providerService.findAllPvd());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        providerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
