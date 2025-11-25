package com.hr.management.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "salaire")
public class Salaire {

    @Id
    private String idSalaire;

    @ManyToOne
    @JoinColumn(name = "id_poste")
    private Poste poste;

    private BigDecimal montant;

    public Salaire(){}

    public Salaire(String idSalaire, Poste poste, BigDecimal montant) {
        this.idSalaire = idSalaire;
        this.poste = poste;
        this.montant = montant;
    }

    public String getIdSalaire() {
        return idSalaire;
    }

    public void setIdSalaire(String idSalaire) {
        this.idSalaire = idSalaire;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

}
