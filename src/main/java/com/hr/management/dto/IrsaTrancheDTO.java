package com.hr.management.dto;
import java.math.BigDecimal;

public class IrsaTrancheDTO {

    private String libelle;    
    private BigDecimal montant; 

    public IrsaTrancheDTO(String libelle, BigDecimal montant) {
        this.libelle = libelle;
        this.montant = montant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}

