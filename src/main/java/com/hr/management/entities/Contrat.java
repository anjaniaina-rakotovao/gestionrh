package com.hr.management.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contrat")
public class Contrat {

    @Id
    private String idContrat;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "id_type_contrat")
    private TypeContrat typeContrat;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Integer duree;
    public Contrat(){};
    public Contrat(String idContrat, Employe employe, TypeContrat typeContrat, LocalDate dateDebut, LocalDate dateFin,
            Integer duree) {
        this.idContrat = idContrat;
        this.employe = employe;
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
    public Employe getEmploye() {
        return employe;
    }
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    public TypeContrat getTypeContrat() {
        return typeContrat;
    }
    public void setTypeContrat(TypeContrat typeContrat) {
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
