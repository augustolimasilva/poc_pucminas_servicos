package com.example.deliveryproviderservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.deliveryproviderservice.model.Provider;

public interface ProviderRepository extends CrudRepository<Provider, Integer> {
}
