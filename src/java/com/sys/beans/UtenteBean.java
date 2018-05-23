package com.sys.beans;

import java.util.Date;

public class UtenteBean {

    private int id;
    private String email;
    private String nome;
    private String cognome;
    private String cf;
    private Date datanascita;
    private String password;
    private String sale;
    private Character sesso;

    public UtenteBean(String email, String nome, String cognome, String cf, Date datanascita, String password, String sale, Character sesso) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.datanascita = datanascita;
        this.password = password;
        this.sale = sale;
        this.sesso = sesso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public Date getDatanascita() {
        return datanascita;
    }

    public void setDatanascita(Date datanascita) {
        this.datanascita = datanascita;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public Character getSesso() {
        return sesso;
    }

    public void setSesso(Character sesso) {
        this.sesso = sesso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
