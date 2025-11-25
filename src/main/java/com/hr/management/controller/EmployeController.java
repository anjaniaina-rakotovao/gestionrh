package com.hr.management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.management.dto.AlerteRHDTO;
import com.hr.management.dto.CritereRechercheEmploye;
import com.hr.management.dto.DocEmployeDTO;
import com.hr.management.dto.DomaineEmployeDTO;
import com.hr.management.dto.EmployeDetailsDTO;
import com.hr.management.dto.EmployeRechercheDTO;
import com.hr.management.dto.PosteDTO;
import com.hr.management.dto.StatistiqueContratDTO;
import com.hr.management.dto.StatistiqueDemographiqueDTO;
import com.hr.management.dto.StatistiquePosteDTO;
import com.hr.management.dto.StatistiqueTurnoverDTO;
import com.hr.management.dto.StatistiqueTurnoverPosteDTO;
import com.hr.management.service.EmployeService;
import com.hr.management.service.DocEmployeService;

@RestController
@RequestMapping("/employes")
public class EmployeController {

    private final EmployeService employeService;
    private final DocEmployeService docEmployeService;

    public EmployeController(EmployeService employeService, DocEmployeService docEmployeService) {
        this.employeService = employeService;
        this.docEmployeService = docEmployeService;
    }

    @GetMapping("/domaines")
    public List<DomaineEmployeDTO> getAllEmployesByDomaines() {
        return employeService.findEmployeByDomaine();
    }

    @GetMapping("/postes")
    public List<PosteDTO> getAllPostes() {
        return employeService.getAllPostes();
    }

    @PostMapping("/recherche")
    public List<EmployeRechercheDTO> searchEmployes(@RequestBody CritereRechercheEmploye criteria) {
        return employeService.searchEmployesDTO(criteria);
    }

    @GetMapping("/{id}/details")
    public EmployeDetailsDTO getEmployeDetails(@PathVariable String id) {
        return employeService.getEmployeDetails(id);
    }

    @GetMapping("/statistiques/demographique/{annee}/{mois}")
    public StatistiqueDemographiqueDTO getStatistiqueDemographique(
            @PathVariable int annee,
            @PathVariable int mois) {
        return employeService.getStatistiqueDemographique(annee, mois);
    }

    @GetMapping("/statistiques/demographique/annees/{annee}")
    public List<StatistiqueDemographiqueDTO> getStatistiquesAnnuelles(
            @PathVariable int annee) {
        return employeService.getStatistiquesAnnuelles(annee);
    }

    @GetMapping("/statistiques/demographique/annee/{annee}")
    public StatistiqueDemographiqueDTO getStatistiqueAnnuelleGlobale(
            @PathVariable int annee) {
        return employeService.getStatistiqueAnnuelleGlobale(annee);
    }

    @GetMapping("/statistiques/demographique/tous")
    public List<StatistiqueDemographiqueDTO> getToutesStatistiques() {
        return employeService.getToutesStatistiques();
    }

    @GetMapping("/statistiques/contrats/{annee}/{mois}")
    public StatistiqueContratDTO getStatistiqueContrat(
            @PathVariable int annee,
            @PathVariable int mois) {
        return employeService.getStatistiqueContrat(annee, mois);
    }

    @GetMapping("/statistiques/contrats/annee/{annee}")
    public List<StatistiqueContratDTO> getStatistiquesContratAnnees(
            @PathVariable int annee) {
        return employeService.getStatistiquesContratAnnees(annee);
    }

    @GetMapping("/statistiques/contrats/annees/{annee}")
    public StatistiqueContratDTO getStatistiqueContratAnnuelleGlobale(
            @PathVariable int annee) {
        return employeService.getStatistiqueContratAnnuelleGlobale(annee);
    }

    @GetMapping("/statistiques/poste")
    public List<StatistiquePosteDTO> getStatistiqueParPoste() {
        return employeService.getStatistiqueParPoste();
    }

    @GetMapping("/statistiques/turnover/{annee}/{mois}")
    public StatistiqueTurnoverDTO getStatistiqueTurnover(
            @PathVariable int annee,
            @PathVariable int mois) {
        return employeService.getStatistiqueTurnover(annee, mois);
    }

    @GetMapping("/alertes")
    public AlerteRHDTO getAlertes() {
        return employeService.getAlertes();
    }

    @GetMapping("/statistiques/turnover/poste/{idPoste}/{annee}/{mois}")
    public StatistiqueTurnoverPosteDTO getTurnoverPoste(
            @PathVariable String idPoste,
            @PathVariable int annee,
            @PathVariable int mois) {
        return employeService.getTurnoverPoste(idPoste, annee, mois);
    }

    @GetMapping("/statistiques/turnover/poste/{idPoste}/annee/{annee}")
    public List<StatistiqueTurnoverPosteDTO> getTurnoverPosteAnnee(
            @PathVariable String idPoste,
            @PathVariable int annee) {
        return employeService.getTurnoverPosteAnnee(idPoste, annee);
    }

    @GetMapping("/statistiques/turnover/tous-postes/{annee}/{mois}")
    public List<StatistiqueTurnoverPosteDTO> getTurnoverTousPostes(
            @PathVariable int annee,
            @PathVariable int mois) {
        return employeService.getTurnoverTousPostes(annee, mois);
    }

    @GetMapping("/{idEmploye}/documents/count")
    public ResponseEntity<Long> getNombreDocumentsEmploye(
            @PathVariable String idEmploye) {

        long count = docEmployeService.countDocumentsByEmploye(idEmploye);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/{idEmploye}/has-documents")
    public ResponseEntity<Boolean> hasDocuments(
            @PathVariable String idEmploye) {

        boolean hasDocuments = docEmployeService.hasDocuments(idEmploye);
        return ResponseEntity.ok(hasDocuments);
    }

    @GetMapping("/employe/{idEmploye}")
    public ResponseEntity<List<DocEmployeDTO>> getDocumentsByEmploye(
            @PathVariable String idEmploye) {

        List<DocEmployeDTO> documents = docEmployeService.getDocumentsByEmploye(idEmploye);

        if (documents.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(documents);
    }

    @GetMapping("/{idDocEmploye}")
    public ResponseEntity<DocEmployeDTO> getDocument(
            @PathVariable String idDocEmploye) {

        DocEmployeDTO document = docEmployeService.getDocumentById(idDocEmploye);

        if (document == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(document);
    }

    @GetMapping("/employe/{idEmploye}/exists")
    public ResponseEntity<Boolean> hasDocuments2(
            @PathVariable String idEmploye) {

        boolean hasDocuments = docEmployeService.hasDocuments(idEmploye);
        return ResponseEntity.ok(hasDocuments);
    }

    @GetMapping("/employe/{idEmploye}/count")
    public ResponseEntity<Long> countDocuments(
            @PathVariable String idEmploye) {

        long count = docEmployeService.countDocumentsByEmploye(idEmploye);
        return ResponseEntity.ok(count);
    }

}
