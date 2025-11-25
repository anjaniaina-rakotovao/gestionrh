package com.hr.management.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "histo_mouvement")
public class HistoMouvement {

    @Id
    private String idHistMouvement;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;

    private Integer retard;
    private Integer heureSup;
    private Integer pauses;
    private Integer absence;
    private LocalDate date;

    public HistoMouvement(){}

    public HistoMouvement(String idHistMouvement, Employe employe, Integer retard, Integer heureSup, Integer pauses,
            Integer absence, LocalDate date) {
        this.idHistMouvement = idHistMouvement;
        this.employe = employe;
        this.retard = retard;
        this.heureSup = heureSup;
        this.pauses = pauses;
        this.absence = absence;
        this.date = date;
    }

    public String getIdHistMouvement() {
        return idHistMouvement;
    }

    public void setIdHistMouvement(String idHistMouvement) {
        this.idHistMouvement = idHistMouvement;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Integer getRetard() {
        return retard;
    }

    public void setRetard(Integer retard) {
        this.retard = retard;
    }

    public Integer getHeureSup() {
        return heureSup;
    }

    public void setHeureSup(Integer heureSup) {
        this.heureSup = heureSup;
    }

    public Integer getPauses() {
        return pauses;
    }

    public void setPauses(Integer pauses) {
        this.pauses = pauses;
    }

    public Integer getAbsence() {
        return absence;
    }

    public void setAbsence(Integer absence) {
        this.absence = absence;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
