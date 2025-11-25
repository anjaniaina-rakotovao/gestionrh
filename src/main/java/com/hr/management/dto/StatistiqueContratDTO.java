package com.hr.management.dto;

import java.time.YearMonth;

public class StatistiqueContratDTO {
    
    private YearMonth periode;  // Année-Mois (ex: 2024-11)
    private Integer totalContrats;
    
    // Par type de contrat
    private Integer nombreCDI;
    private Integer nombreCDD;
    private Integer nombreApprentissage;
    
    // Pourcentages (optionnel)
    private Double pourcentageCDI;
    private Double pourcentageCDD;
    private Double pourcentageApprentissage;

    // Constructeur vide
    public StatistiqueContratDTO() {
    }

    // Constructeur complet
    public StatistiqueContratDTO(YearMonth periode, Integer totalContrats,
                                Integer nombreCDI, Integer nombreCDD, Integer nombreApprentissage) {
        this.periode = periode;
        this.totalContrats = totalContrats;
        this.nombreCDI = nombreCDI;
        this.nombreCDD = nombreCDD;
        this.nombreApprentissage = nombreApprentissage;
        
        // Calculer les pourcentages
        if (totalContrats > 0) {
            this.pourcentageCDI = (nombreCDI.doubleValue() / totalContrats) * 100;
            this.pourcentageCDD = (nombreCDD.doubleValue() / totalContrats) * 100;
            this.pourcentageApprentissage = (nombreApprentissage.doubleValue() / totalContrats) * 100;
        }
    }

    // Getters et Setters
    public YearMonth getPeriode() {
        return periode;
    }

    public void setPeriode(YearMonth periode) {
        this.periode = periode;
    }

    public Integer getTotalContrats() {
        return totalContrats;
    }

    public void setTotalContrats(Integer totalContrats) {
        this.totalContrats = totalContrats;
    }

    public Integer getNombreCDI() {
        return nombreCDI;
    }

    public void setNombreCDI(Integer nombreCDI) {
        this.nombreCDI = nombreCDI;
    }

    public Integer getNombreCDD() {
        return nombreCDD;
    }

    public void setNombreCDD(Integer nombreCDD) {
        this.nombreCDD = nombreCDD;
    }

    public Integer getNombreApprentissage() {
        return nombreApprentissage;
    }

    public void setNombreApprentissage(Integer nombreApprentissage) {
        this.nombreApprentissage = nombreApprentissage;
    }

    public Double getPourcentageCDI() {
        return pourcentageCDI;
    }

    public void setPourcentageCDI(Double pourcentageCDI) {
        this.pourcentageCDI = pourcentageCDI;
    }

    public Double getPourcentageCDD() {
        return pourcentageCDD;
    }

    public void setPourcentageCDD(Double pourcentageCDD) {
        this.pourcentageCDD = pourcentageCDD;
    }

    public Double getPourcentageApprentissage() {
        return pourcentageApprentissage;
    }

    public void setPourcentageApprentissage(Double pourcentageApprentissage) {
        this.pourcentageApprentissage = pourcentageApprentissage;
    }
}