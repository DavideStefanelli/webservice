/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.ejbs;

import com.sys.entities.Libro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author web4e
 */
@Local
public interface BibliotecaEjbLocal {
   
    public List<Libro> getByName(String name);
    public List<Libro> getByAuthor(String author);
    public Libro getById(int id);
    
}
