package com.hr.management.dto;

import java.math.BigDecimal;

public class TauxHoraireDTO {
    private String idEmploye;
    private int mois;
    private int annee;
    private BigDecimal tauxhoraire;

    public TauxHoraireDTO() {
    }

    public TauxHoraireDTO(String idEmploye, int mois, int annee, BigDecimal tauxhoraire) {
        this.idEmploye = idEmploye;
        this.mois = mois;
        this.annee = annee;
        this.tauxhoraire = tauxhoraire;
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

    public BigDecimal getTauxHoraire() {
        return tauxhoraire;
    }

    public void setTauxHoraire(BigDecimal tauxhoraire) {
        this.tauxhoraire = tauxhoraire;
    }
}
