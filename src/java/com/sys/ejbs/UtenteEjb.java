package com.sys.ejbs;

import com.sys.beans.UtenteBean;
import com.sys.entities.Utente;
import java.util.concurrent.ThreadLocalRandom;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.commons.codec.digest.DigestUtils;
 
@Stateless
public class UtenteEjb implements UtenteEjbLocal {
    
    @PersistenceContext(unitName = "EJB_JAX_WS_WebServicePU")
    EntityManager em;
    
    private UtenteBean utente;
    
    @Override
    public boolean registraUtente(UtenteBean uBean){
        String sale = Long.toUnsignedString(ThreadLocalRandom.current().nextLong());
        
        String passwordHash = DigestUtils.sha256Hex(uBean.getPassword() + sale);
        
        Utente utente = new Utente(
            uBean.getEmail(),
            uBean.getCf(),
            uBean.getNome(),
            uBean.getCognome(),
            uBean.getDatanascita(),
            passwordHash,
            sale,
            uBean.getSesso()
        );
        
        em.persist(utente); 

        return em.contains(utente);
    }

    @Override
    public UtenteBean eseguiLogin(String email, String password) {
     
        TypedQuery<Utente> utenti = 
                em.createNamedQuery("Utente.findByEmail", Utente.class)
                .setParameter("email", email);
        
        if(!utenti.getResultList().isEmpty()){
            
            Utente u = utenti.getResultList().get(0); 
            String passwordHash = DigestUtils.sha256Hex(password + u.getSale()); 
            
            if(u.getPassword().equals(passwordHash)){
                UtenteBean uBean = new UtenteBean( 
                        u.getEmail(), u.getNome(), u.getCognome(), u.getCf(), u.getDatanascita(), u.getPassword(), u.getSale(), u.getSesso()
                );
                uBean.setId(u.getId());
                this.utente = uBean;
                return uBean;
            }
            
        }
        return null;
    }

    @Override
    public UtenteBean getUtente() {
        return utente;
    }
    
    @Override
    public boolean isLoggedIn(){
        return utente != null;
    } 
    
    
}
