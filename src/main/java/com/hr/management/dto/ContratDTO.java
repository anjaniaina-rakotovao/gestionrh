package com.hr.management.dto;

import java.time.LocalDate;

public class ContratDTO {
    
    private String idContrat;
    private String typeContrat;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Integer duree;

    public ContratDTO() {
    }

    public ContratDTO(String idContrat, String typeContrat, LocalDate dateDebut, LocalDate dateFin, Integer duree) {
        this.idContrat = idContrat;
        this.typeContrat = typeContrat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.duree = duree;
    }

    public String getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(String idContrat) {
        this.idContrat = idContrat;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
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

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }
}