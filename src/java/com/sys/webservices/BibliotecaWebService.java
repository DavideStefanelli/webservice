package com.sys.webservices;

import com.sys.beans.UtenteBean;
import com.sys.ejbs.BibliotecaEjbLocal;
import com.sys.ejbs.UtenteEjbLocal;
import com.sys.entities.Libro;
import com.sys.exceptions.UserNotAuthenticatedException;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "BibliotecaWebService")
public class BibliotecaWebService {

    @EJB 
    private UtenteEjbLocal utenteEjb;
    
    @EJB
    private BibliotecaEjbLocal ejbRef;

    @WebMethod(operationName = "login")
    public UtenteBean login(@WebParam(name = "email")String email, @WebParam(name = "password") String password) {
        return utenteEjb.eseguiLogin(email, password);
    }
    
    @WebMethod(operationName = "register")
    public boolean register(@WebParam(name = "uBean") UtenteBean uBean){
        return utenteEjb.registraUtente(uBean);
    }
    
    private void checkAuthentication() throws Exception {
        if(!utenteEjb.isLoggedIn()) throw new UserNotAuthenticatedException();
    }
    
    @WebMethod(operationName = "getByName")
    public List<Libro> getByName(@WebParam(name = "name") String name) throws Exception {
        checkAuthentication();
        return ejbRef.getByName(name);
    }

    @WebMethod(operationName = "getByAuthor")
    public List<Libro> getByAuthor(@WebParam(name = "author") String author) throws Exception {
        checkAuthentication();
        return ejbRef.getByAuthor(author);
    }

    @WebMethod(operationName = "getById")
    public Libro getById(@WebParam(name = "id") int id) throws Exception {
        checkAuthentication();
        return ejbRef.getById(id);
    }
    
}
