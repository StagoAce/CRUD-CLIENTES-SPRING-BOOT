package com.base.datos.springbootdatajpa.Models.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "clientes")

public class Cliente implements Serializable {

    @Id
    @Column(length = 10)
    @NotEmpty
    @Size(max = 10)
    private String Id;

    @NotEmpty(message = "{NotEmpty.Cliente.Nombre}")
    @Size(max = 20)
    @Column(length = 20, nullable = false)
    private String primerNombre;

    @Column(nullable = true)
    private String segundoNombre;

    @NotEmpty
    @Column(nullable = false)
    @Size(min = 1)
    private String sexo;

    @NotNull
    @Min(value = 1, message = "La edad debe ser mayor que cero")
    @Column(nullable = false)
    private int edad;

    @Email(message = "{Email.Cliente.Email}")
    @NotEmpty(message = "{NotEmpty.Cliente.Email}")
    @Column(nullable = false)
    private String Email;

    @NotEmpty
    @Column(nullable = false)
    @Size(max = 30)
    private String direccion;

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    

    

    
    
}
