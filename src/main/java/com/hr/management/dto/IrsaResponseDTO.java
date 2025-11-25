package com.hr.management.dto;

import java.math.BigDecimal;
import java.util.List;

public class IrsaResponseDTO {

    private int mois;
    private int annee;
    private String employe;
    private List<IrsaTrancheDTO> tranches;   
    private BigDecimal totalIrsa;            

    public IrsaResponseDTO(int mois, int annee, String employe, List<IrsaTrancheDTO> tranches, BigDecimal totalIrsa) {
        this.mois = mois;
        this.annee = annee;
        this.employe = employe;
        this.tranches = tranches;
        this.totalIrsa = totalIrsa;
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

    public String getEmploye() {
        return employe;
    }

    public void setEmploye(String employe) {
        this.employe = employe;
    }

    public List<IrsaTrancheDTO> getTranches() {
        return tranches;
    }

    public void setTranches(List<IrsaTrancheDTO> tranches) {
        this.tranches = tranches;
    }

    public BigDecimal getTotalIrsa() {
        return totalIrsa;
    }

    public void setTotalIrsa(BigDecimal totalIrsa) {
        this.totalIrsa = totalIrsa;
    }
}

