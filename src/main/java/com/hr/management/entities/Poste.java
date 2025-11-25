package com.hr.management.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "poste")
public class Poste {

    @Id
    @Column(name = "id_poste")
    private String idPoste;

    private String libelle;

    @ManyToOne
    @JoinColumn(name = "id_domaine")
    private Domaine domaine;

    @OneToMany(mappedBy = "poste")
    private List<EmployePoste> employePostes;

    @OneToMany(mappedBy = "poste")
    private List<Salaire> salaires;

    public Poste(String idPoste, String libelle, Domaine domaine, List<EmployePoste> employePostes,
            List<Salaire> salaires) {
        this.idPoste = idPoste;
        this.libelle = libelle;
        this.domaine = domaine;
        this.employePostes = employePostes;
        this.salaires = salaires;
    }

    public Poste() {
    }

    public String getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(String idPoste) {
        this.idPoste = idPoste;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public List<EmployePoste> getEmployePostes() {
        return employePostes;
    }

    public void setEmployePostes(List<EmployePoste> employePostes) {
        this.employePostes = employePostes;
    }

    public List<Salaire> getSalaires() {
        return salaires;
    }

    public void setSalaires(List<Salaire> salaires) {
        this.salaires = salaires;
    }

 

}
