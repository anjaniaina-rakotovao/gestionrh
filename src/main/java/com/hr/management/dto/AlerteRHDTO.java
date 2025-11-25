package com.hr.management.dto;

import java.time.LocalDate;
import java.util.List;

public class AlerteRHDTO {

    private List<AlerteContratDTO> alertesContrats;
    private List<AlerteCongeDTO> alertesCongés;

    public AlerteRHDTO(List<AlerteContratDTO> alertesContrats, List<AlerteCongeDTO> alertesCongés) {
        this.alertesContrats = alertesContrats;
        this.alertesCongés = alertesCongés;
    }

    public List<AlerteContratDTO> getAlertsContrats() {
        return alertesContrats;
    }

    public void setAlertsContrats(List<AlerteContratDTO> alertesContrats) {
        this.alertesContrats = alertesContrats;
    }

    public List<AlerteCongeDTO> getAlertsCongés() {
        return alertesCongés;
    }

    public void setAlertsCongés(List<AlerteCongeDTO> alertesCongés) {
        this.alertesCongés = alertesCongés;
    }

    // Inner class pour alertes de contrat
    public static class AlerteContratDTO {
        private String idEmploye;
        private String nomPrenom;
        private String typeContrat;
        private LocalDate dateFinContrat;
        private Integer joursRestants;
        private String severite; // "URGENT" (< 30j), "ATTENTION" (30-60j), "INFO" (> 60j)

        public AlerteContratDTO(String idEmploye, String nomPrenom, String typeContrat,
                LocalDate dateFinContrat, Integer joursRestants, String severite) {
            this.idEmploye = idEmploye;
            this.nomPrenom = nomPrenom;
            this.typeContrat = typeContrat;
            this.dateFinContrat = dateFinContrat;
            this.joursRestants = joursRestants;
            this.severite = severite;
        }

        // Getters
        public String getIdEmploye() {
            return idEmploye;
        }

        public String getNomPrenom() {
            return nomPrenom;
        }

        public String getTypeContrat() {
            return typeContrat;
        }

        public LocalDate getDateFinContrat() {
            return dateFinContrat;
        }

        public Integer getJoursRestants() {
            return joursRestants;
        }

        public String getSeverite() {
            return severite;
        }
    }

    // Inner class pour alertes de congé
    public static class AlerteCongeDTO {
        private String idEmploye;
        private String nomPrenom;
        private Integer congesNonPris;
        private Integer congesDisponibles;
        private String severite; // "URGENT" (> 20j non pris), "ATTENTION" (10-20j)

        public AlerteCongeDTO(String idEmploye, String nomPrenom, Integer congesNonPris,
                Integer congesDisponibles, String severite) {
            this.idEmploye = idEmploye;
            this.nomPrenom = nomPrenom;
            this.congesNonPris = congesNonPris;
            this.congesDisponibles = congesDisponibles;
            this.severite = severite;
        }

        // Getters
        public String getIdEmploye() {
            return idEmploye;
        }

        public String getNomPrenom() {
            return nomPrenom;
        }

        public Integer getCongesNonPris() {
            return congesNonPris;
        }

        public Integer getCongesDisponibles() {
            return congesDisponibles;
        }

        public String getSeverite() {
            return severite;
        }
    }
}