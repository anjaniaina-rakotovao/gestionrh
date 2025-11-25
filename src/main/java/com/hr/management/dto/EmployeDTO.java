package com.hr.management.dto;

public class EmployeDTO {
    private String idEmploye;
    private String nom;
    private String prenom;
    private String posteActuel; 


    public EmployeDTO(String idEmploye, String nom, String prenom, String posteActuel) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.prenom = prenom;
        this.posteActuel = posteActuel;
    }


    public String getIdEmploye() {
        return idEmploye;
    }


    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getPosteActuel() {
        return posteActuel;
    }


    public void setPosteActuel(String posteActuel) {
        this.posteActuel = posteActuel;
    }
    
}
