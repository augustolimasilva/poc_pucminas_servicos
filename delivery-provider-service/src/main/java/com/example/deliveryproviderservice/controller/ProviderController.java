package com.example.deliveryproviderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.deliveryproviderservice.model.Provider;
import com.example.deliveryproviderservice.service.ProviderService;


@RestController
@RequestMapping(value = "/api/providers", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProviderController {
	
	@Autowired
    private ProviderService providerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Provider> save(@RequestBody  Provider provider){
        return ResponseEntity.ok(providerService.save(provider));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Provider> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(providerService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Provider>> findAll(){
        return ResponseEntity.ok().body(providerService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        providerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
