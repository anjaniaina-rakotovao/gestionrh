package com.hr.management.dto;

import java.time.YearMonth;
import java.util.List;
import java.time.LocalDate;

public class StatistiqueTurnoverPosteDTO {
    
    private String idPoste;
    private String posteLibelle;
    private String domaineLibelle;
    private YearMonth periode;
    
    // Turnover
    private Integer effectifDebut;      // Effectif au début de la période
    private Integer effectifFin;        // Effectif à la fin de la période
    private Integer nombreDeparts;     // Nombre de personnes parties
    private Integer nombreArrivees;    // Nombre de personnes arrivées
    private Integer nombreChangements; // Total des changements
    private Double tauxTurnover;       // (Départs / Effectif moyen) * 100
    
    // Listes des employés
    private List<HistoriqueEmployeDTO> employes;

    // Constructeur vide
    public StatistiqueTurnoverPosteDTO() {
    }

    // Constructeur complet
    public StatistiqueTurnoverPosteDTO(String idPoste, String posteLibelle, String domaineLibelle,
                                      YearMonth periode, Integer effectifDebut, Integer effectifFin,
                                      Integer nombreDeparts, Integer nombreArrivees, Integer nombreChangements,
                                      Double tauxTurnover, List<HistoriqueEmployeDTO> employes) {
        this.idPoste = idPoste;
        this.posteLibelle = posteLibelle;
        this.domaineLibelle = domaineLibelle;
        this.periode = periode;
        this.effectifDebut = effectifDebut;
        this.effectifFin = effectifFin;
        this.nombreDeparts = nombreDeparts;
        this.nombreArrivees = nombreArrivees;
        this.nombreChangements = nombreChangements;
        this.tauxTurnover = tauxTurnover;
        this.employes = employes;
    }

    // Getters et Setters
    public String getIdPoste() { return idPoste; }
    public void setIdPoste(String idPoste) { this.idPoste = idPoste; }
    
    public String getPosteLibelle() { return posteLibelle; }
    public void setPosteLibelle(String posteLibelle) { this.posteLibelle = posteLibelle; }
    
    public String getDomaineLibelle() { return domaineLibelle; }
    public void setDomaineLibelle(String domaineLibelle) { this.domaineLibelle = domaineLibelle; }
    
    public YearMonth getPeriode() { return periode; }
    public void setPeriode(YearMonth periode) { this.periode = periode; }
    
    public Integer getEffectifDebut() { return effectifDebut; }
    public void setEffectifDebut(Integer effectifDebut) { this.effectifDebut = effectifDebut; }
    
    public Integer getEffectifFin() { return effectifFin; }
    public void setEffectifFin(Integer effectifFin) { this.effectifFin = effectifFin; }
    
    public Integer getNombreDeparts() { return nombreDeparts; }
    public void setNombreDeparts(Integer nombreDeparts) { this.nombreDeparts = nombreDeparts; }
    
    public Integer getNombreArrivees() { return nombreArrivees; }
    public void setNombreArrivees(Integer nombreArrivees) { this.nombreArrivees = nombreArrivees; }
    
    public Integer getNombreChangements() { return nombreChangements; }
    public void setNombreChangements(Integer nombreChangements) { this.nombreChangements = nombreChangements; }
    
    public Double getTauxTurnover() { return tauxTurnover; }
    public void setTauxTurnover(Double tauxTurnover) { this.tauxTurnover = tauxTurnover; }
    
    public List<HistoriqueEmployeDTO> getEmployes() { return employes; }
    public void setEmployes(List<HistoriqueEmployeDTO> employes) { this.employes = employes; }

    // ============================================
    // Inner class - Historique des employés au poste
    // ============================================
    public static class HistoriqueEmployeDTO {
        private String idEmploye;
        private String nom;
        private String prenom;
        private LocalDate dateDebut;
        private LocalDate dateFin;
        private String statut;  // "ACTUEL", "PARTI", "ARRIVÉ"

        public HistoriqueEmployeDTO() {
        }

        public HistoriqueEmployeDTO(String idEmploye, String nom, String prenom,
                                   LocalDate dateDebut, LocalDate dateFin, String statut) {
            this.idEmploye = idEmploye;
            this.nom = nom;
            this.prenom = prenom;
            this.dateDebut = dateDebut;
            this.dateFin = dateFin;
            this.statut = statut;
        }

        // Getters et Setters
        public String getIdEmploye() { return idEmploye; }
        public void setIdEmploye(String idEmploye) { this.idEmploye = idEmploye; }
        
        public String getNom() { return nom; }
        public void setNom(String nom) { this.nom = nom; }
        
        public String getPrenom() { return prenom; }
        public void setPrenom(String prenom) { this.prenom = prenom; }
        
        public LocalDate getDateDebut() { return dateDebut; }
        public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
        
        public LocalDate getDateFin() { return dateFin; }
        public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
        
        public String getStatut() { return statut; }
        public void setStatut(String statut) { this.statut = statut; }

        @Override
        public String toString() {
            return "HistoriqueEmployeDTO{" +
                    "idEmploye='" + idEmploye + '\'' +
                    ", nom='" + nom + '\'' +
                    ", prenom='" + prenom + '\'' +
                    ", dateDebut=" + dateDebut +
                    ", dateFin=" + dateFin +
                    ", statut='" + statut + '\'' +
                    '}';
        }
    }
}