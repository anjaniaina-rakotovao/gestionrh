package com.hr.management.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "domaine")
public class Domaine {

    @Id
    private String idDomaine;

    private String libelle;

    @OneToMany(mappedBy = "domaine")
    private List<Poste> postes;

    public Domaine(String idDomaine, String libelle, List<Poste> postes) {
        this.idDomaine = idDomaine;
        this.libelle = libelle;
        this.postes = postes;
    }

    public Domaine() {
    }

    public String getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(String idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Poste> getPostes() {
        return postes;
    }

    public void setPostes(List<Poste> postes) {
        this.postes = postes;
    }

    
}

