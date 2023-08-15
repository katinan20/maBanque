package com.paulo.pauloBanque.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("Versement")
public class Versement extends Operation{

    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }

    public Versement() {
    }
}
