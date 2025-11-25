package com.hr.management.dto;

import java.time.LocalDate;

public class EmployePosteDTO {
    
    private String idEmployePoste;
    private String posteLibelle;
    private String domaineLibelle;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Boolean actuel; // true si dateFin est null

    public EmployePosteDTO() {
    }

    public EmployePosteDTO(String idEmployePoste, String posteLibelle, String domaineLibelle,
                          LocalDate dateDebut, LocalDate dateFin, Boolean actuel) {
        this.idEmployePoste = idEmployePoste;
        this.posteLibelle = posteLibelle;
        this.domaineLibelle = domaineLibelle;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.actuel = actuel;
    }

    public String getIdEmployePoste() {
        return idEmployePoste;
    }

    public void setIdEmployePoste(String idEmployePoste) {
        this.idEmployePoste = idEmployePoste;
    }

    public String getPosteLibelle() {
        return posteLibelle;
    }

    public void setPosteLibelle(String posteLibelle) {
        this.posteLibelle = posteLibelle;
    }

    public String getDomaineLibelle() {
        return domaineLibelle;
    }

    public void setDomaineLibelle(String domaineLibelle) {
        this.domaineLibelle = domaineLibelle;
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

    public Boolean getActuel() {
        return actuel;
    }

    public void setActuel(Boolean actuel) {
        this.actuel = actuel;
    }
}