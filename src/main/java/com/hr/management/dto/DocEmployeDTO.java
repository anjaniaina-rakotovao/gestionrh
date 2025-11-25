package com.hr.management.dto;


public class DocEmployeDTO {
    private String idDocEmploye;
    private String idEmploye;
    private String imagePath;
    private String nomFichier;
    private String typeDocument;
    
    // Constructeurs
    public DocEmployeDTO() {}
    
    public DocEmployeDTO(String idDocEmploye, String idEmploye, String imagePath) {
        this.idDocEmploye = idDocEmploye;
        this.idEmploye = idEmploye;
        this.imagePath = imagePath;
        // Extraire le nom de fichier du chemin
        if (imagePath != null && imagePath.contains("/")) {
            this.nomFichier = imagePath.substring(imagePath.lastIndexOf("/") + 1);
        } else {
            this.nomFichier = imagePath;
        }
    }
    
    // Getters et Setters
    public String getIdDocEmploye() { return idDocEmploye; }
    public void setIdDocEmploye(String idDocEmploye) { this.idDocEmploye = idDocEmploye; }
    
    public String getIdEmploye() { return idEmploye; }
    public void setIdEmploye(String idEmploye) { this.idEmploye = idEmploye; }
    
    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { 
        this.imagePath = imagePath;
        // Mettre à jour le nom de fichier
        if (imagePath != null && imagePath.contains("/")) {
            this.nomFichier = imagePath.substring(imagePath.lastIndexOf("/") + 1);
        } else {
            this.nomFichier = imagePath;
        }
    }
    
    public String getNomFichier() { return nomFichier; }
    public void setNomFichier(String nomFichier) { this.nomFichier = nomFichier; }
    
    public String getTypeDocument() { return typeDocument; }
    public void setTypeDocument(String typeDocument) { this.typeDocument = typeDocument; }
}