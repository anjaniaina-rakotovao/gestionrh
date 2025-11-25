package com.hr.management.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "statut_conge")
public class StatutConge {

    @Id
    @Column(name = "id_statut_conge")
    private String idStatutConge;

    @ManyToOne
    @JoinColumn(name = "id_conge")
    @JsonBackReference
    private Conge conge;

    @Column(name = "date_statut")
    private LocalDate dateStatut;

    @ManyToOne
    @JoinColumn(name = "id_statut")
    @JsonBackReference
    private Statut statut;

    // Getters & Setters
    public String getIdStatutConge() { return idStatutConge; }
    public void setIdStatutConge(String idStatutConge) { this.idStatutConge = idStatutConge; }

    public Conge getConge() { return conge; }
    public void setConge(Conge conge) { this.conge = conge; }

    public LocalDate getDateStatut() { return dateStatut; }
    public void setDateStatut(LocalDate dateStatut) { this.dateStatut = dateStatut; }

    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }
}
