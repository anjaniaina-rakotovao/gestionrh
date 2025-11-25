package com.hr.management.dto;

import java.math.BigDecimal;

public class TauxJournalierDTO {
    private String idEmploye;
    private int mois;
    private int annee;
    private BigDecimal tauxjournalier;

    public TauxJournalierDTO() {
    }

    public TauxJournalierDTO(String idEmploye, int mois, int annee, BigDecimal tauxjournalier) {
        this.idEmploye = idEmploye;
        this.mois = mois;
        this.annee = annee;
        this.tauxjournalier = tauxjournalier;
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

    public BigDecimal getTauxJournalier() {
        return tauxjournalier;
    }

    public void setTauxJournalier(BigDecimal tauxjournalier) {
        this.tauxjournalier = tauxjournalier;
    }
}
