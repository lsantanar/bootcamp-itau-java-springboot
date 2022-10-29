package com.itau.spring02.repository;

import com.itau.spring02.model.Carro;

import org.springframework.data.repository.CrudRepository;

public interface CarroRepo extends CrudRepository<Carro, Long> {
        
}
