package com.hr.management.dto;

public class EmployeRechercheDTO {
    private String id;
    private String nom;
    private String prenom;
    private String domaine;
    private String posteActuel;
    private Integer age;

    public EmployeRechercheDTO(String id, String nom, String prenom, String domaine, String posteActuel, Integer age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.domaine = domaine;
        this.posteActuel = posteActuel;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getPosteActuel() {
        return posteActuel;
    }

    public void setPosteActuel(String posteActuel) {
        this.posteActuel = posteActuel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
