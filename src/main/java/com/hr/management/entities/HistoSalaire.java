package com.hr.management.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "histo_salaire")
public class HistoSalaire {

    @Id
    private String idHistoSalaire;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;

    private Integer mois;
    private Integer annee;
    private BigDecimal montantNet;

    public HistoSalaire(){}

    public HistoSalaire(String idHistoSalaire, Employe employe, Integer mois, Integer annee, BigDecimal montantNet) {
        this.idHistoSalaire = idHistoSalaire;
        this.employe = employe;
        this.mois = mois;
        this.annee = annee;
        this.montantNet = montantNet;
    }

    public String getIdHistoSalaire() {
        return idHistoSalaire;
    }

    public void setIdHistoSalaire(String idHistoSalaire) {
        this.idHistoSalaire = idHistoSalaire;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public BigDecimal getMontantNet() {
        return montantNet;
    }

    public void setMontantNet(BigDecimal montantNet) {
        this.montantNet = montantNet;
    }

}
