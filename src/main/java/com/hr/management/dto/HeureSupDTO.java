package com.hr.management.dto;

import java.math.BigDecimal;

public class HeureSupDTO {
    private String idEmploye;
    private int mois;
    private int annee;
    private BigDecimal indemnite;

    public HeureSupDTO() {
    }

    public HeureSupDTO(String idEmploye, int mois, int annee, BigDecimal indemnite) {
        this.idEmploye = idEmploye;
        this.mois = mois;
        this.annee = annee;
        this.indemnite = indemnite;
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

    public BigDecimal getIndemnite() {
        return indemnite;
    }

    public void setIndemnite(BigDecimal indemnite) {
        this.indemnite = indemnite;
    }
}
