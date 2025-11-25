package com.hr.management.entities;

import jakarta.persistence.*;
import java.util.List;

// import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sexe")
public class Sexe {

    @Id
    private String idSexe;

    private String libelle;

    @OneToMany(mappedBy = "sexe")
    @JsonIgnore
    private List<Employe> employes;

    public Sexe(){

    }

    public Sexe(String idSexe, String libelle, List<Employe> employes) {
        this.idSexe = idSexe;
        this.libelle = libelle;
        this.employes = employes;
    }

    public String getIdSexe() {
        return idSexe;
    }

    public void setIdSexe(String idSexe) {
        this.idSexe = idSexe;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

}
