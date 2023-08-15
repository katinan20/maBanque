package com.paulo.pauloBanque.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Collection;
import java.util.Date;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{
    private double taux;
    public CompteEpargne(String numCompte, Date dateCreation, Double solde,
                         Client client, double taux) {
        super(numCompte, dateCreation, solde, client);
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
