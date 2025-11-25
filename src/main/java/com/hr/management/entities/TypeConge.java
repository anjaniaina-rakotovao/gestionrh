package com.hr.management.entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "type_conge")
public class TypeConge {

    @Id
    private String idTypeConge;

    private String libelle;
    private Integer dureeMax;

    @OneToMany(mappedBy = "typeConge")
    @JsonIgnore
    private List<Conge> conges;

    public TypeConge(String idTypeConge, String libelle, Integer dureeMax, List<Conge> conges) {
        this.idTypeConge = idTypeConge;
        this.libelle = libelle;
        this.dureeMax = dureeMax;
        this.conges = conges;
    }

    public TypeConge() {
    }

    public String getIdTypeConge() {
        return idTypeConge;
    }

    public void setIdTypeConge(String idTypeConge) {
        this.idTypeConge = idTypeConge;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getDureeMax() {
        return dureeMax;
    }

    public void setDureeMax(Integer dureeMax) {
        this.dureeMax = dureeMax;
    }

    public List<Conge> getConges() {
        return conges;
    }

    public void setConges(List<Conge> conges) {
        this.conges = conges;
    }

    
}
