package com.paulo.pauloBanque.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Collection;
import java.util.Date;

@Entity
@DiscriminatorValue("CPT_EPGNE")
public class CompteEpargne extends Compte{
    private double taux;
    public CompteEpargne(String numCompte, Date dateCreation, Double solde, Client client, Collection<Operation> operations, double taux) {
        super(numCompte, dateCreation, solde, client, operations);
        this.taux = taux;
    }

    public CompteEpargne(){}

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
