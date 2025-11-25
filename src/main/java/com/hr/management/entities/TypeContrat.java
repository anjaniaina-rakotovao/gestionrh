package com.hr.management.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_contrat")
public class TypeContrat {

    @Id
    private String idTypeContrat;

    private String libelle;
    private Integer dureeMax;

    @OneToMany(mappedBy = "typeContrat")
    private List<Contrat> contrats;

    public TypeContrat() {
    }

    public TypeContrat(String idTypeContrat, String libelle, Integer dureeMax, List<Contrat> contrats) {
        this.idTypeContrat = idTypeContrat;
        this.libelle = libelle;
        this.dureeMax = dureeMax;
        this.contrats = contrats;
    }

    public String getIdTypeContrat() {
        return idTypeContrat;
    }

    public void setIdTypeContrat(String idTypeContrat) {
        this.idTypeContrat = idTypeContrat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getDureeMax() {
        return dureeMax;
    }

    public void setDureeMax(Integer dureeMax) {
        this.dureeMax = dureeMax;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    
}
