package com.itau.spring02.controller;

import com.itau.spring02.model.Carro;
import com.itau.spring02.repository.CarroRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*") //aceita de qualquer lugar 
@RequestMapping("/car")
public class CarroController {

    @Autowired
    private CarroRepo repo;

    @GetMapping("/id/{id}")
    public ResponseEntity<Carro> obterCarro(@PathVariable long id) {
        Carro carroEncontrado = repo.findById(id).orElse(null);

        if(carroEncontrado != null) {
            return ResponseEntity.ok(carroEncontrado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
