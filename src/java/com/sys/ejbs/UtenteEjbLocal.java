package com.sys.ejbs;
 
import com.sys.beans.UtenteBean;
import javax.ejb.Local; 

@Local
public interface UtenteEjbLocal {
    
    public boolean registraUtente(UtenteBean uBean);
    public UtenteBean eseguiLogin(String email, String password);
    public UtenteBean getUtente();
    public boolean isLoggedIn();
    
}
