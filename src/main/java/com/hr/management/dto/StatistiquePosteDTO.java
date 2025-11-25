package com.hr.management.dto;

import java.util.List;

public class StatistiquePosteDTO {
    
    private String idPoste;
    private String posteLibelle;
    private String domaineLibelle;
    private Integer totalEmployes;
    private Double salaireMoyen;
    private Double ancienneteteMoyenne;  // En années
    private Integer nombreChangements;   // Nombre de changements de poste
    private List<String> employesActuels;

    // Constructeur vide
    public StatistiquePosteDTO() {
    }

    public StatistiquePosteDTO(String idPoste, String posteLibelle, String domaineLibelle,
                              Integer totalEmployes, Double salaireMoyen, Double ancienneteteMoyenne,
                              Integer nombreChangements, List<String> employesActuels) {
        this.idPoste = idPoste;
        this.posteLibelle = posteLibelle;
        this.domaineLibelle = domaineLibelle;
        this.totalEmployes = totalEmployes;
        this.salaireMoyen = salaireMoyen;
        this.ancienneteteMoyenne = ancienneteteMoyenne;
        this.nombreChangements = nombreChangements;
        this.employesActuels = employesActuels;
    }

    // Getters et Setters
    public String getIdPoste() { return idPoste; }
    public void setIdPoste(String idPoste) { this.idPoste = idPoste; }
    
    public String getPosteLibelle() { return posteLibelle; }
    public void setPosteLibelle(String posteLibelle) { this.posteLibelle = posteLibelle; }
    
    public String getDomaineLibelle() { return domaineLibelle; }
    public void setDomaineLibelle(String domaineLibelle) { this.domaineLibelle = domaineLibelle; }
    
    public Integer getTotalEmployes() { return totalEmployes; }
    public void setTotalEmployes(Integer totalEmployes) { this.totalEmployes = totalEmployes; }
    
    public Double getSalaireMoyen() { return salaireMoyen; }
    public void setSalaireMoyen(Double salaireMoyen) { this.salaireMoyen = salaireMoyen; }
    
    public Double getAncienneteteMoyenne() { return ancienneteteMoyenne; }
    public void setAncienneteteMoyenne(Double ancienneteteMoyenne) { this.ancienneteteMoyenne = ancienneteteMoyenne; }
    
    public Integer getNombreChangements() { return nombreChangements; }
    public void setNombreChangements(Integer nombreChangements) { this.nombreChangements = nombreChangements; }
    
    public List<String> getEmployesActuels() { return employesActuels; }
    public void setEmployesActuels(List<String> employesActuels) { this.employesActuels = employesActuels; }
}