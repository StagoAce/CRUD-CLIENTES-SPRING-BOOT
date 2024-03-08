package com.base.datos.springbootdatajpa.Models.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.base.datos.springbootdatajpa.Models.Entity.Cliente;

@Repository
public class ClienteDaoImp implements IClienteDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findall() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        if (cliente.getId() != null && cliente.getId().length() > 0) {
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }

    }

    @Override
    @Transactional(readOnly = true) // utiliza la base de datos pero no la modifica
    public Cliente findOne(String Id) {

        return em.find(Cliente.class, Id);
    }

    @Override
    @Transactional
    public void delete(String Id) {
        Cliente cliente = findOne(Id); // buscar con el metodo que tenemos

        em.remove(cliente); // eliminar

    }

    @Override
    public void update(Cliente cliente) {
        em.merge(cliente);
    }

}
