package com.itau.spring02.repository;

import com.itau.spring02.model.Usuario;

import org.springframework.data.repository.CrudRepository;

//terá um repositório (CrudRepository) capaz de fazer o CRUD 
//dentro da chave vai o Tipo de classe (Usuario) e o Tipo de chave primária (Long)
public interface UsuarioRepo extends CrudRepository<Usuario, Long> { //Crud = create, read, update, delete

    
}