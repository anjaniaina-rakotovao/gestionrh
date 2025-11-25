package com.hr.management.dto;
import java.math.BigDecimal;

public class SalaireDTO {
    private String idSalaire;
    private BigDecimal montant;
    private String idPoste;
    
    public SalaireDTO() {
    }

    public SalaireDTO(String idSalaire, BigDecimal montant, String idPoste) {
        this.idSalaire = idSalaire;
        this.montant = montant;
        this.idPoste = idPoste;
    }

    public String getIdSalaire() {
        return idSalaire;
    }

    public void setIdSalaire(String idSalaire) {
        this.idSalaire = idSalaire;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(String idPoste) {
        this.idPoste = idPoste;
    }
}