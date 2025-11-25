package com.hr.management.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "statut")
public class Statut {

    @Id
    private String idStatut;

    private String libelle;

    @OneToMany(mappedBy = "statut")
    private List<StatutConge> statutConges;

    public Statut(){
        
    }
    public Statut(String idStatut, String libelle, List<StatutConge> statutConges) {
        this.idStatut = idStatut;
        this.libelle = libelle;
        this.statutConges = statutConges;
    }

    public String getIdStatut() {
        return idStatut;
    }

    public void setIdStatut(String idStatut) {
        this.idStatut = idStatut;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<StatutConge> getStatutConges() {
        return statutConges;
    }

    public void setStatutConges(List<StatutConge> statutConges) {
        this.statutConges = statutConges;
    }

}
