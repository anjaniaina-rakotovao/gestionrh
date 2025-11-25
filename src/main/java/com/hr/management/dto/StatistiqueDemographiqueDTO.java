package com.hr.management.dto;

import java.time.YearMonth;

public class StatistiqueDemographiqueDTO {
    
    private YearMonth periode;  // Année-Mois (ex: 2024-11)
    private Integer totalEmployes;
    
    // Par sexe
    private Integer nombreHommes;
    private Integer nombreFemmes;
    
    // Par catégorie d'âge
    private Integer age18_20;
    private Integer age20_40;
    private Integer age40_60;
    private Integer age60Plus;
    
    // Pourcentages (optionnel)
    private Double pourcentageHommes;
    private Double pourcentageFemmes;

    // Constructeur vide
    public StatistiqueDemographiqueDTO() {
    }

    // Constructeur complet
    public StatistiqueDemographiqueDTO(YearMonth periode, Integer totalEmployes,
                                      Integer nombreHommes, Integer nombreFemmes,
                                      Integer age18_20, Integer age20_40, Integer age40_60, Integer age60Plus) {
        this.periode = periode;
        this.totalEmployes = totalEmployes;
        this.nombreHommes = nombreHommes;
        this.nombreFemmes = nombreFemmes;
        this.age18_20 = age18_20;
        this.age20_40 = age20_40;
        this.age40_60 = age40_60;
        this.age60Plus = age60Plus;
        
        // Calculer les pourcentages
        if (totalEmployes > 0) {
            this.pourcentageHommes = (nombreHommes.doubleValue() / totalEmployes) * 100;
            this.pourcentageFemmes = (nombreFemmes.doubleValue() / totalEmployes) * 100;
        }
    }

    // Getters et Setters
    public YearMonth getPeriode() {
        return periode;
    }

    public void setPeriode(YearMonth periode) {
        this.periode = periode;
    }

    public Integer getTotalEmployes() {
        return totalEmployes;
    }

    public void setTotalEmployes(Integer totalEmployes) {
        this.totalEmployes = totalEmployes;
    }

    public Integer getNombreHommes() {
        return nombreHommes;
    }

    public void setNombreHommes(Integer nombreHommes) {
        this.nombreHommes = nombreHommes;
    }

    public Integer getNombreFemmes() {
        return nombreFemmes;
    }

    public void setNombreFemmes(Integer nombreFemmes) {
        this.nombreFemmes = nombreFemmes;
    }

    public Integer getAge18_20() {
        return age18_20;
    }

    public void setAge18_20(Integer age18_20) {
        this.age18_20 = age18_20;
    }

    public Integer getAge20_40() {
        return age20_40;
    }

    public void setAge20_40(Integer age20_40) {
        this.age20_40 = age20_40;
    }

    public Integer getAge40_60() {
        return age40_60;
    }

    public void setAge40_60(Integer age40_60) {
        this.age40_60 = age40_60;
    }

    public Integer getAge60Plus() {
        return age60Plus;
    }

    public void setAge60Plus(Integer age60Plus) {
        this.age60Plus = age60Plus;
    }

    public Double getPourcentageHommes() {
        return pourcentageHommes;
    }

    public void setPourcentageHommes(Double pourcentageHommes) {
        this.pourcentageHommes = pourcentageHommes;
    }

    public Double getPourcentageFemmes() {
        return pourcentageFemmes;
    }

    public void setPourcentageFemmes(Double pourcentageFemmes) {
        this.pourcentageFemmes = pourcentageFemmes;
    }
}