package com.paulo.pauloBanque.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE", discriminatorType = DiscriminatorType.STRING, length = 6)
public abstract class Compte implements Serializable {
   @Id
    private String numCompte;
    private Date dateCreation;
    private Double solde;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "compte")
    private Collection<Operation>operations;

    public Compte(String numCompte, Date dateCreation, Double solde, Client client, Collection<Operation> operations) {
        this.numCompte = numCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
        this.operations = operations;
    }

    public Compte(){}

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }
}
