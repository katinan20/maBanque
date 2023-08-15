package com.paulo.pauloBanque.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Collection;
import java.util.Date;

@Entity
@DiscriminatorValue("CPT_CRT")
public class CompteCourant extends Compte{

    private double decouvert;

    public CompteCourant(String numCompte, Date dateCreation, Double solde, Client client, Collection<Operation> operations, double decouvert) {
        super(numCompte, dateCreation, solde, client, operations);
        this.decouvert = decouvert;
    }

    public CompteCourant() {
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
