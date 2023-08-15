package com.paulo.pauloBanque.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("Retrait")
public class Retrait extends Operation{

    public Retrait(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }

    public Retrait() {
    }
}
