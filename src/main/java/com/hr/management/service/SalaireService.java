package com.hr.management.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.management.dto.IrsaResponseDTO;
import com.hr.management.dto.IrsaTrancheDTO;
import com.hr.management.dto.SalaireDTO;
import com.hr.management.entities.HistoMouvement;
import com.hr.management.repository.HistoMouvementRepository;
import com.hr.management.repository.SalaireRepository;

@Service
public class SalaireService {

    @Autowired
    private SalaireRepository salaireRepository;

    @Autowired
    private HistoMouvementRepository histoMouvementRepository;


    public List<SalaireDTO> getAllSalaires() {
        return salaireRepository.findAll().stream()
                .map(s -> new SalaireDTO(
                        s.getIdSalaire(),
                        s.getMontant(),
                        s.getPoste() != null ? s.getPoste().getIdPoste() : null))
                .collect(Collectors.toList());
    }

    public BigDecimal getRetenuSurAbsence(String idEmploye, int mois, int annee) {
        LocalDate debutMois = LocalDate.of(annee, mois, 1);
        LocalDate finMois = debutMois.withDayOfMonth(debutMois.lengthOfMonth());

        String idPoste = histoMouvementRepository.findIdPosteByEmploye(idEmploye, debutMois, finMois);
        if (idPoste == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal salaireBase = salaireRepository.findByPosteId(idPoste)
                .map(s -> s.getMontant())
                .orElse(BigDecimal.ZERO);

        Integer nbAbsence = histoMouvementRepository.findAbsenceByEmployeAndMonth(idEmploye, debutMois, finMois);
        if (nbAbsence == null || nbAbsence == 0) {
            return BigDecimal.ZERO;
        }

        return salaireBase
                .multiply(new BigDecimal(nbAbsence))
                .divide(new BigDecimal(30), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getSalaireBase(String idEmploye, int mois, int annee) {
        LocalDate debutMois = LocalDate.of(annee, mois, 1);
        LocalDate finMois = debutMois.withDayOfMonth(debutMois.lengthOfMonth());

        String idPoste = histoMouvementRepository.findIdPosteByEmploye(idEmploye, debutMois, finMois);
        if (idPoste == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal salaireBrut = salaireRepository.findByPosteId(idPoste)
                .map(s -> s.getMontant())
                .orElse(BigDecimal.ZERO);

        BigDecimal retenue = getRetenuSurAbsence(idEmploye, mois, annee);

        return salaireBrut.subtract(retenue)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTauxJournalier(String idEmploye, int mois, int annee) {
        LocalDate debutMois = LocalDate.of(annee, mois, 1);
        LocalDate finMois = debutMois.withDayOfMonth(debutMois.lengthOfMonth());

        String idPoste = histoMouvementRepository.findIdPosteByEmploye(idEmploye, debutMois, finMois);
        if (idPoste == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal salaireBrut = salaireRepository.findByPosteId(idPoste)
                .map(s -> s.getMontant())
                .orElse(BigDecimal.ZERO);

        return salaireBrut
                .divide(new BigDecimal(30), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTauxHoraire(String idEmploye, int mois, int annee) {
        LocalDate debutMois = LocalDate.of(annee, mois, 1);
        LocalDate finMois = debutMois.withDayOfMonth(debutMois.lengthOfMonth());

        String idPoste = histoMouvementRepository.findIdPosteByEmploye(idEmploye, debutMois, finMois);
        if (idPoste == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal salaireBrut = salaireRepository.findByPosteId(idPoste)
                .map(s -> s.getMontant())
                .orElse(BigDecimal.ZERO);

        return salaireBrut
                .divide(new BigDecimal(173.33), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getMontantHeureSup(String idEmploye, int mois, int annee) {
        LocalDate debutMois = LocalDate.of(annee, mois, 1);
        LocalDate finMois = debutMois.withDayOfMonth(debutMois.lengthOfMonth());

        BigDecimal tauxHoraire = getTauxHoraire(idEmploye, mois, annee);
        if (tauxHoraire.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        // Définir les jours fériés pour l'année
        List<LocalDate> joursFeries = List.of(
                LocalDate.of(annee, 1, 1), // Nouvel An
                LocalDate.of(annee, 12, 25), // Noël
                LocalDate.of(annee, 6, 26) // 26 juin
        );

        // Récupérer tous les mouvements de l'employé pour le mois
        List<HistoMouvement> mouvements = histoMouvementRepository.findAll().stream()
                .filter(h -> h.getEmploye().getIdEmploye().equals(idEmploye))
                .filter(h -> !h.getDate().isBefore(debutMois) && !h.getDate().isAfter(finMois))
                .collect(Collectors.toList());

        // Grouper les mouvements par semaine ISO
        Map<Integer, List<HistoMouvement>> semaines = mouvements.stream()
                .collect(Collectors.groupingBy(h -> h.getDate().get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)));

        BigDecimal total = BigDecimal.ZERO;

        for (List<HistoMouvement> semaine : semaines.values()) {
            int heuresSemaineNormales = 0;

            for (HistoMouvement h : semaine) {
                DayOfWeek day = h.getDate().getDayOfWeek();
                int heuresSup = h.getHeureSup() != null ? h.getHeureSup() : 0;

                if (joursFeries.contains(h.getDate())) {
                    // Jour férié : 2 × taux horaire
                    total = total
                            .add(tauxHoraire.multiply(BigDecimal.valueOf(heuresSup)).multiply(BigDecimal.valueOf(2.0)));
                } else if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                    // Week-end : 1.4 × taux horaire
                    total = total
                            .add(tauxHoraire.multiply(BigDecimal.valueOf(heuresSup)).multiply(BigDecimal.valueOf(1.4)));
                } else {
                    // Semaine normale
                    heuresSemaineNormales += heuresSup;
                }
            }

            // Heures normales de la semaine : 1.3 × pour les 8 premières heures, 1.5 × pour
            // les 12 suivantes
            int heuresPremieres8 = Math.min(heuresSemaineNormales, 8);
            int heuresSuivantes12 = Math.max(0, Math.min(heuresSemaineNormales - 8, 12));

            total = total
                    .add(tauxHoraire.multiply(BigDecimal.valueOf(heuresPremieres8)).multiply(BigDecimal.valueOf(1.3)));
            total = total
                    .add(tauxHoraire.multiply(BigDecimal.valueOf(heuresSuivantes12)).multiply(BigDecimal.valueOf(1.5)));
        }

        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getSalaireBrut(String idEmploye, int mois, int annee) {
        BigDecimal salaireBase = getSalaireBase(idEmploye, mois, annee);
        BigDecimal heureSup = getMontantHeureSup(idEmploye, mois, annee);

        return salaireBase
                .add(heureSup);
    }

    public BigDecimal getCnapsUnPercent(String idEmploye, int mois, int annee) {
        BigDecimal salaireBrut = getSalaireBrut(idEmploye, mois, annee);

        BigDecimal valueCnaps = salaireBrut.multiply(new BigDecimal("0.01"));

        BigDecimal plafond = new BigDecimal("10080");

        if (valueCnaps.compareTo(plafond) <= 0) {
            return valueCnaps.setScale(2, RoundingMode.HALF_UP);
        } else {
            return plafond;
        }
    }

    public BigDecimal getOstieUnPercent(String idEmploye, int mois, int annee) {
        BigDecimal salaireBrut = getSalaireBrut(idEmploye, mois, annee);

        BigDecimal ValueOstie = salaireBrut.multiply(new BigDecimal("0.01"));

        return ValueOstie;
    }

    public BigDecimal getRevenuImposable(String idEmploye, int mois, int annee) {
        BigDecimal cnaps = getCnapsUnPercent(idEmploye, mois, annee);
        BigDecimal ostie = getOstieUnPercent(idEmploye, mois, annee);
        BigDecimal salaireBrut = getSalaireBrut(idEmploye, mois, annee);

        return salaireBrut.subtract(cnaps.add(ostie)).setScale(2, RoundingMode.HALF_UP);
    }

    public IrsaResponseDTO getIrsa(String idEmploye, int mois, int annee) {

        BigDecimal revenu = getRevenuImposable(idEmploye, mois, annee);
        List<IrsaTrancheDTO> tranches = new ArrayList<>();
        BigDecimal totalIrsa = BigDecimal.ZERO;

        if (revenu.compareTo(new BigDecimal("350000")) <= 0) {
            return new IrsaResponseDTO(mois, annee, idEmploye, tranches, BigDecimal.ZERO);
        }

        if (revenu.compareTo(new BigDecimal("350000")) > 0) {
            BigDecimal montant = new BigDecimal("50000").multiply(new BigDecimal("0.05"));
            totalIrsa = totalIrsa.add(montant);
            tranches.add(new IrsaTrancheDTO("350001 - 400000", montant.setScale(2, RoundingMode.HALF_UP)));
        }

        if (revenu.compareTo(new BigDecimal("400000")) > 0) {
            BigDecimal montant = new BigDecimal("100000").multiply(new BigDecimal("0.10"));
            totalIrsa = totalIrsa.add(montant);
            tranches.add(new IrsaTrancheDTO("400001 - 500000", montant.setScale(2, RoundingMode.HALF_UP)));
        }

        if (revenu.compareTo(new BigDecimal("500000")) > 0) {
            BigDecimal montant = new BigDecimal("100000").multiply(new BigDecimal("0.15"));
            totalIrsa = totalIrsa.add(montant);
            tranches.add(new IrsaTrancheDTO("500001 - 600000", montant.setScale(2, RoundingMode.HALF_UP)));
        }

        if (revenu.compareTo(new BigDecimal("600000")) > 0) {
            BigDecimal montant = new BigDecimal("100000").multiply(new BigDecimal("0.20"));
            totalIrsa = totalIrsa.add(montant);
            tranches.add(new IrsaTrancheDTO("600001 - 4000000", montant.setScale(2, RoundingMode.HALF_UP)));
        }

        if (revenu.compareTo(new BigDecimal("4000000")) > 0) {
            BigDecimal montant = revenu.subtract(new BigDecimal("4000000")).multiply(new BigDecimal("0.25"));
            totalIrsa = totalIrsa.add(montant);
            tranches.add(new IrsaTrancheDTO("4000001 et plus", montant.setScale(2, RoundingMode.HALF_UP)));
        }

        return new IrsaResponseDTO(mois, annee, idEmploye, tranches, totalIrsa.setScale(2, RoundingMode.HALF_UP));
    }

    
    public BigDecimal getRetenuTotal(String idEmploye, int mois, int annee) {
        BigDecimal cnaps = getCnapsUnPercent(idEmploye, mois, annee);
        BigDecimal ostie = getOstieUnPercent(idEmploye, mois, annee);
        IrsaResponseDTO irsa = getIrsa(idEmploye, mois, annee);
        BigDecimal irsaMontant = irsa.getTotalIrsa();

        return cnaps.add(ostie).add(irsaMontant).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getSalaireNet(String idEmploye, int mois, int annee) {
        BigDecimal salaireBrut = getSalaireBrut(idEmploye, mois, annee);
        BigDecimal retenuTotal = getRetenuTotal(idEmploye, mois, annee);

        return salaireBrut.subtract(retenuTotal).setScale(2, RoundingMode.HALF_UP);
    }

}
