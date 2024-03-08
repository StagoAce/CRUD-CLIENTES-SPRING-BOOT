package com.base.datos.springbootdatajpa.Models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.base.datos.springbootdatajpa.Models.Entity.Cliente;

public interface IClienteDao
{
    public List<Cliente>findall();    

    public void save(Cliente cliente);

    public Cliente findOne(String Id);

    public void delete(String Id);

    public void update(Cliente cliente);

    
}
