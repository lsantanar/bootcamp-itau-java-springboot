package com.itau.spring02.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Esta classe será mapeada no Banco de Dados
@Table(name = "tb_usuario") //
public class Usuario {
    
    @Id //Será chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //O BD gera este código automaticamente, em sequência: 1, 2, 3... 
    private long id; //long é para chave primária

    @Column(name = "nome", length = 200, nullable = false) //Serve para criar uma coluna, com limite de 200 letras, e nu
    private String nome;

    @Column(name = "email", length = 80, nullable = false, unique = true)
    private String email;

    //Um usuário pode ter vários carros
    @OneToMany(mappedBy = "proprietario")
    @JsonIgnoreProperties("proprietario")
    private List<Carro> carros;

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
