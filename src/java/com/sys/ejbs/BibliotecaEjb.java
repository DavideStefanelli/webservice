/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.ejbs;

import com.sys.entities.Libro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author web4e
 */
@Stateless
public class BibliotecaEjb implements BibliotecaEjbLocal {

    @PersistenceContext(unitName = "EJB_JAX_WS_WebServicePU")
    EntityManager em;
    
    @Override
    public List<Libro> getByName(String titolo) { 
        return em.createNamedQuery("Libro.findByTitolo", Libro.class).setParameter("titolo", "%" + titolo + "%").getResultList();
    }

    @Override
    public List<Libro> getByAuthor(String author) {
        return em.createNamedQuery("Libro.findByAutore", Libro.class).setParameter("autore", "%" + author + "%").getResultList();
    }

    @Override
    public Libro getById(int id) {
        TypedQuery<Libro> libri = em.createNamedQuery("Libro.findById", Libro.class).setParameter("id", id);
        if(libri.getResultList().isEmpty() == false){
            return libri.getSingleResult();
        } else {
            return null;
        }
    }
    
}
