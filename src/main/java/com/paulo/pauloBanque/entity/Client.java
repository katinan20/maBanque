package com.paulo.pauloBanque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue
    private long code;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "client")
    private Collection<Compte> comptes;

    public Client(String nom, String email, Collection<Compte> comptes) {
        this.nom = nom;
        this.email = email;
        this.comptes = comptes;
    }

    public Client(){}

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
