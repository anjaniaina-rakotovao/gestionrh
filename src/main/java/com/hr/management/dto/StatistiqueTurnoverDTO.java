package com.hr.management.dto;

import java.time.YearMonth;

public class StatistiqueTurnoverDTO {
    
    private YearMonth periode;
    
    // Turnover (départs / effectif moyen * 100)
    private Integer nombreDeparts;
    private Integer effectifMoyen;
    private Double tauxTurnover;  // En pourcentage
    
    // Absentéisme
    private Integer joursAbsenceTotaux;
    private Integer joursOuvrables;
    private Double tauxAbsenteisme;  // En pourcentage
    
    // Ancienneté moyenne
    private Double ancienneteteMoyenne;  // En années
    
    // Congés
    private Integer congesNonPris;
    private Integer congesPris;

    public StatistiqueTurnoverDTO() {
    }

    public StatistiqueTurnoverDTO(YearMonth periode, Integer nombreDeparts, Integer effectifMoyen,
                                 Integer joursAbsenceTotaux, Integer joursOuvrables,
                                 Double ancienneteteMoyenne, Integer congesNonPris, Integer congesPris) {
        this.periode = periode;
        this.nombreDeparts = nombreDeparts;
        this.effectifMoyen = effectifMoyen;
        this.tauxTurnover = effectifMoyen > 0 ? (nombreDeparts.doubleValue() / effectifMoyen) * 100 : 0;
        this.joursAbsenceTotaux = joursAbsenceTotaux;
        this.joursOuvrables = joursOuvrables;
        this.tauxAbsenteisme = joursOuvrables > 0 ? (joursAbsenceTotaux.doubleValue() / joursOuvrables) * 100 : 0;
        this.ancienneteteMoyenne = ancienneteteMoyenne;
        this.congesNonPris = congesNonPris;
        this.congesPris = congesPris;
    }

    // Getters et Setters
    public YearMonth getPeriode() { return periode; }
    public void setPeriode(YearMonth periode) { this.periode = periode; }
    
    public Integer getNombreDeparts() { return nombreDeparts; }
    public void setNombreDeparts(Integer nombreDeparts) { this.nombreDeparts = nombreDeparts; }
    
    public Integer getEffectifMoyen() { return effectifMoyen; }
    public void setEffectifMoyen(Integer effectifMoyen) { this.effectifMoyen = effectifMoyen; }
    
    public Double getTauxTurnover() { return tauxTurnover; }
    public void setTauxTurnover(Double tauxTurnover) { this.tauxTurnover = tauxTurnover; }
    
    public Integer getJoursAbsenceTotaux() { return joursAbsenceTotaux; }
    public void setJoursAbsenceTotaux(Integer joursAbsenceTotaux) { this.joursAbsenceTotaux = joursAbsenceTotaux; }
    
    public Integer getJoursOuvrables() { return joursOuvrables; }
    public void setJoursOuvrables(Integer joursOuvrables) { this.joursOuvrables = joursOuvrables; }
    
    public Double getTauxAbsenteisme() { return tauxAbsenteisme; }
    public void setTauxAbsenteisme(Double tauxAbsenteisme) { this.tauxAbsenteisme = tauxAbsenteisme; }
    
    public Double getAncienneteteMoyenne() { return ancienneteteMoyenne; }
    public void setAncienneteteMoyenne(Double ancienneteteMoyenne) { this.ancienneteteMoyenne = ancienneteteMoyenne; }
    
    public Integer getCongesNonPris() { return congesNonPris; }
    public void setCongesNonPris(Integer congesNonPris) { this.congesNonPris = congesNonPris; }
    
    public Integer getCongesPris() { return congesPris; }
    public void setCongesPris(Integer congesPris) { this.congesPris = congesPris; }
}