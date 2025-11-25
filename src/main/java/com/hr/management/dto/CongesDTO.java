package com.hr.management.dto;

import java.time.LocalDate;

public class CongesDTO {
    private String idConge;
    private String employeNom;
    private String employePrenom;
    private String typeConge;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String statut;

    // Getters et Setters
    public String getIdConge() { return idConge; }
    public void setIdConge(String idConge) { this.idConge = idConge; }

    public String getEmployeNom() { return employeNom; }
    public void setEmployeNom(String employeNom) { this.employeNom = employeNom; }

    public String getEmployePrenom() { return employePrenom; }
    public void setEmployePrenom(String employePrenom) { this.employePrenom = employePrenom; }

    public String getTypeConge() { return typeConge; }
    public void setTypeConge(String typeConge) { this.typeConge = typeConge; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}

