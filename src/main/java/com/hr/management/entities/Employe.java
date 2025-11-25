package com.hr.management.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employe")
public class Employe {

    @Id
    @Column(name = "id_employe") 
    private String idEmploye;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String mail;
    private String adresse;
    private String contact;
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "id_sexe")
    private Sexe sexe;

    @OneToMany(mappedBy = "employe")
    @JsonIgnore
    private List<DocEmploye> docEmployes;

    @OneToMany(mappedBy = "employe")
    @JsonIgnore
    private List<Contrat> contrats;

    @OneToMany(mappedBy = "employe")
    @JsonIgnore
    private List<EmployePoste> employePostes;

    @OneToMany(mappedBy = "employe")
    @JsonIgnore
    private List<HistoMouvement> histoMouvements;

    @OneToMany(mappedBy = "employe")
    @JsonIgnore
    private List<Presence> presences;

    @OneToMany(mappedBy = "employe")
    @JsonIgnore
    private List<Conge> conges;

    @OneToMany(mappedBy = "employe")
    @JsonIgnore
    private List<HistoSalaire> histoSalaires;

    public Employe(String idEmploye, String nom, String prenom, LocalDate dateNaissance, String mail, String adresse,
            String contact, String imagePath, Sexe sexe, List<DocEmploye> docEmployes, List<Contrat> contrats,
            List<EmployePoste> employePostes, List<HistoMouvement> histoMouvements, List<Presence> presences,
            List<Conge> conges, List<HistoSalaire> histoSalaires) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.mail = mail;
        this.adresse = adresse;
        this.contact = contact;
        this.imagePath = imagePath;
        this.sexe = sexe;
        this.docEmployes = docEmployes;
        this.contrats = contrats;
        this.employePostes = employePostes;
        this.histoMouvements = histoMouvements;
        this.presences = presences;
        this.conges = conges;
        this.histoSalaires = histoSalaires;
    }

    public Employe() {
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

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public List<DocEmploye> getDocEmployes() {
        return docEmployes;
    }

    public void setDocEmployes(List<DocEmploye> docEmployes) {
        this.docEmployes = docEmployes;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public List<EmployePoste> getEmployePostes() {
        return employePostes;
    }

    public void setEmployePostes(List<EmployePoste> employePostes) {
        this.employePostes = employePostes;
    }

    public List<HistoMouvement> getHistoMouvements() {
        return histoMouvements;
    }

    public void setHistoMouvements(List<HistoMouvement> histoMouvements) {
        this.histoMouvements = histoMouvements;
    }

    public List<Presence> getPresences() {
        return presences;
    }

    public void setPresences(List<Presence> presences) {
        this.presences = presences;
    }

    public List<Conge> getConges() {
        return conges;
    }

    public void setConges(List<Conge> conges) {
        this.conges = conges;
    }

    public List<HistoSalaire> getHistoSalaires() {
        return histoSalaires;
    }

    public void setHistoSalaires(List<HistoSalaire> histoSalaires) {
        this.histoSalaires = histoSalaires;
    }

}
