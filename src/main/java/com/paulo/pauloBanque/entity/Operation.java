package com.paulo.pauloBanque.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tpe_opt", discriminatorType = DiscriminatorType.STRING, length = 9)
public abstract class Operation implements Serializable {
    @Id
    @GeneratedValue
    private long numOperation;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    private Compte compte;

    public Operation(Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }

    public Operation(){}

    public long getNumOperation() {
        return numOperation;
    }

    public void setNumOperation(long numOperation) {
        this.numOperation = numOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
