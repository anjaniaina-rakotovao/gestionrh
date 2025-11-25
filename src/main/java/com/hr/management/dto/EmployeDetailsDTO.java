package com.hr.management.dto;

import java.time.LocalDate;
import java.util.List;

public class EmployeDetailsDTO {
    
    private String idEmploye;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String mail;
    private String adresse;
    private String contact;
    private String imagePath;
    private String sexe;
    
    // Historiques
    private List<ContratDTO> historiquesContrats;
    private List<EmployePosteDTO> historiquesPostes;

    // Constructeur vide
    public EmployeDetailsDTO() {
    }

    // Constructeur avec 11 paramètres (11 = idEmploye + nom + prenom + dateNaissance + mail + adresse + contact + imagePath + sexe + historiquesContrats + historiquesPostes)
    public EmployeDetailsDTO(String idEmploye, String nom, String prenom, LocalDate dateNaissance,
                            String mail, String adresse, String contact, String imagePath, String sexe,
                            List<ContratDTO> historiquesContrats, List<EmployePosteDTO> historiquesPostes) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.mail = mail;
        this.adresse = adresse;
        this.contact = contact;
        this.imagePath = imagePath;
        this.sexe = sexe;
        this.historiquesContrats = historiquesContrats;
        this.historiquesPostes = historiquesPostes;
    }

    // Getters et Setters
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public List<ContratDTO> getHistoriquesContrats() {
        return historiquesContrats;
    }

    public void setHistoriquesContrats(List<ContratDTO> historiquesContrats) {
        this.historiquesContrats = historiquesContrats;
    }

    public List<EmployePosteDTO> getHistoriquesPostes() {
        return historiquesPostes;
    }

    public void setHistoriquesPostes(List<EmployePosteDTO> historiquesPostes) {
        this.historiquesPostes = historiquesPostes;
    }
}