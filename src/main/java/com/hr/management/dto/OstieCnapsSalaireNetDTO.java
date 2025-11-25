package com.hr.management.dto;

import java.math.BigDecimal;

public class OstieCnapsSalaireNetDTO {

    private String idEmploye;
    private BigDecimal cnaps;
    private BigDecimal ostie;
    private BigDecimal salaireNet;

    // 🔹 Constructeur vide
    public OstieCnapsSalaireNetDTO() {}

    // 🔹 Constructeur complet
    public OstieCnapsSalaireNetDTO(BigDecimal cnaps, BigDecimal ostie, BigDecimal salaireNet, String idEmploye) {
        this.idEmploye = idEmploye;
        this.cnaps = cnaps;
        this.ostie = ostie;
        this.salaireNet = salaireNet;
    }

    // 🔹 Getters & Setters
    public BigDecimal getCnaps() {
        return cnaps;
    }

    public void setCnaps(BigDecimal cnaps) {
        this.cnaps = cnaps;
    }

    public BigDecimal getOstie() {
        return ostie;
    }

    public void setOstie(BigDecimal ostie) {
        this.ostie = ostie;
    }

    public BigDecimal getSalaireNet() {
        return salaireNet;
    }

    public void setSalaireNet(BigDecimal salaireNet) {
        this.salaireNet = salaireNet;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }
}
