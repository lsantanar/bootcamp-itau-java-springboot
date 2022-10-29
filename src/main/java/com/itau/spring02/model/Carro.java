package com.itau.spring02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80, nullable = false)
    private String marca;
    
    @Column(length = 80, nullable = false)
    private String modelo;
    
    @Column(length = 80, nullable = false, unique = true)
    private String placa;

    // Cada carro é de um único proprietário
    // Mas um proprietário pode ter vários carros
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties("carros") // ao buscar o proprietário não traga novamente os carros
    private Usuario proprietario;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Usuario getProprietario() {
        return proprietario;
    }
    public void setProprietario(Usuario proprietario) {
        this.proprietario = proprietario;
    }
}
