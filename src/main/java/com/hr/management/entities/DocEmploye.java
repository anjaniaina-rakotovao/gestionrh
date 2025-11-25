package com.hr.management.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "doc_employe")
public class DocEmploye {
     public DocEmploye() {
    }

    public DocEmploye(String idDocEmploye, String imagePath, Employe employe) {
        this.idDocEmploye = idDocEmploye;
        this.imagePath = imagePath;
        this.employe = employe;
    }

    @Id
    private String idDocEmploye;

    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    @JsonIgnore
    private Employe employe;

    public String getIdDocEmploye() {
        return idDocEmploye;
    }

    public void setIdDocEmploye(String idDocEmploye) {
        this.idDocEmploye = idDocEmploye;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

}
