package com.hr.management.dto;

import java.math.BigDecimal;

public class SalaireMontantDTO {
    private String idEmploye;
    private int mois;
    private int annee;
    private BigDecimal montant;

    public SalaireMontantDTO() {
    }

    public SalaireMontantDTO(String idEmploye, int mois, int annee, BigDecimal montant) {
        this.idEmploye = idEmploye;
        this.mois = mois;
        this.annee = annee;
        this.montant = montant;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}
