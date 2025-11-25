package com.hr.management.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
// import java.time.LocalDate;
import java.util.Date;
import java.util.List;

// import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "conge")
public class Conge {

    @Id
    @Column(name = "id_conge")
    private String idConge;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    @JsonManagedReference(value = "employe-conges")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "id_type_conge")
    private TypeConge typeConge;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @OneToMany(mappedBy = "conge")
    @JsonManagedReference
    private List<StatutConge> statuts;

    // Getters & Setters
    public String getIdConge() {
        return idConge;
    }

    public void setIdConge(String idConge) {
        this.idConge = idConge;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public TypeConge getTypeConge() {
        return typeConge;
    }

    public void setTypeConge(TypeConge typeConge) {
        this.typeConge = typeConge;
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

    public List<StatutConge> getStatuts() {
        return statuts;
    }

    public void setStatuts(List<StatutConge> statuts) {
        this.statuts = statuts;
    }
}
