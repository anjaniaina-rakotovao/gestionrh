package com.hr.management.entities;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;
@Entity
@Table(name = "presence")
public class Presence {

    @Id
    @Column(name = "id_presence")
    private String idPresence;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    @JsonManagedReference
    private Employe employe;

    private String mouvement;

    private java.util.Date date;

    // Getters & Setters
    public String getIdPresence() { return idPresence; }
    public void setIdPresence(String idPresence) { this.idPresence = idPresence; }

    public Employe getEmploye() { return employe; }
    public void setEmploye(Employe employe) { this.employe = employe; }

    public String getMouvement() { return mouvement; }
    public void setMouvement(String mouvement) { this.mouvement = mouvement; }

    public java.util.Date getDate() { return date; }
    public void setDate(java.util.Date date) { this.date = date; }
}
