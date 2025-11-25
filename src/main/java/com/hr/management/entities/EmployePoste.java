package com.hr.management.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employe_poste")
public class EmployePoste {

    @Id
    private String idEmployePoste;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "id_poste")
    private Poste poste;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    public EmployePoste(){
        
    }
    public EmployePoste(String idEmployePoste, Employe employe, Poste poste, LocalDate dateDebut, LocalDate dateFin) {
        this.idEmployePoste = idEmployePoste;
        this.employe = employe;
        this.poste = poste;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    public String getIdEmployePoste() {
        return idEmployePoste;
    }
    public void setIdEmployePoste(String idEmployePoste) {
        this.idEmployePoste = idEmployePoste;
    }
    public Employe getEmploye() {
        return employe;
    }
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    public Poste getPoste() {
        return poste;
    }
    public void setPoste(Poste poste) {
        this.poste = poste;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

}

