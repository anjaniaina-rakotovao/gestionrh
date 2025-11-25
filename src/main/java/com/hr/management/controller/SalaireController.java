package com.hr.management.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.management.dto.HeureSupDTO;
import com.hr.management.dto.IrsaResponseDTO;
import com.hr.management.dto.OstieCnapsSalaireNetDTO;
import com.hr.management.dto.SalaireDTO;
import com.hr.management.dto.SalaireMontantDTO;
import com.hr.management.dto.TauxHoraireDTO;
import com.hr.management.dto.TauxJournalierDTO;
import com.hr.management.service.SalaireService;

@RestController
@RequestMapping("api/salaire")
public class SalaireController {
    @Autowired
    private SalaireService salaireService;

    @GetMapping
    public List<SalaireDTO> getAllSalaire() {
        return salaireService.getAllSalaires();
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/retenuSurAbsence")
    public SalaireMontantDTO getRetenuSurAbsence(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal salaireRetenu = salaireService.getRetenuSurAbsence(idEmploye, mois, annee);

        return new SalaireMontantDTO(idEmploye, mois, annee, salaireRetenu);
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/salaireBase")
    public SalaireMontantDTO getSalaireBase(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal salaireBase = salaireService.getSalaireBase(idEmploye, mois, annee);

        return new SalaireMontantDTO(idEmploye, mois, annee, salaireBase);
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/tauxJournalier")
    public TauxJournalierDTO getTauxJournalier(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal tauxjournalier = salaireService.getTauxJournalier(idEmploye, mois, annee);

        return new TauxJournalierDTO(idEmploye, mois, annee, tauxjournalier);
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/tauxHoraire")
    public TauxHoraireDTO getTauxHoraire(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal tauxHoraire = salaireService.getTauxHoraire(idEmploye, mois, annee);

        return new TauxHoraireDTO(idEmploye, mois, annee, tauxHoraire);
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/tauxHeureSup")
    public HeureSupDTO getHeureSup(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal indemnite = salaireService.getMontantHeureSup(idEmploye, mois, annee);

        return new HeureSupDTO(idEmploye, mois, annee, indemnite);
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/salaireBrut")
    public SalaireMontantDTO getSalaireBrut(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal indemnite = salaireService.getSalaireBrut(idEmploye, mois, annee);

        return new SalaireMontantDTO(idEmploye, mois, annee, indemnite);
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/irsaTranche")
    public ResponseEntity<IrsaResponseDTO> getIrsaTranche(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        IrsaResponseDTO response = salaireService.getIrsa(idEmploye, mois, annee);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/retenuTotal")
    public BigDecimal getRetenuTotal(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal retenuTotal = salaireService.getRetenuTotal(idEmploye, mois, annee);

        return retenuTotal;
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/cnaps")
    public BigDecimal getCnaps(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal cnaps = salaireService.getCnapsUnPercent(idEmploye, mois, annee);

        return cnaps;
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/ostie")
    public BigDecimal getOstie(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal ostie = salaireService.getOstieUnPercent(idEmploye, mois, annee);

        return ostie;
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/salaireNet")
    public SalaireMontantDTO getSalaireNet(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal salaireNet = salaireService.getSalaireNet(idEmploye, mois, annee);

        return new SalaireMontantDTO(idEmploye, mois, annee, salaireNet);
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/details")
    public OstieCnapsSalaireNetDTO getDetail(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        BigDecimal cnaps = salaireService.getCnapsUnPercent(idEmploye, mois, annee);
        BigDecimal ostie = salaireService.getOstieUnPercent(idEmploye, mois, annee);
        BigDecimal salaireNet = salaireService.getSalaireNet(idEmploye, mois, annee);

        return new OstieCnapsSalaireNetDTO(cnaps, ostie, salaireNet, idEmploye);
    }

}
