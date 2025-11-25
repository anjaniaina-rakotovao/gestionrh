package com.hr.management.controller;

import com.hr.management.dto.CongesDTO;
import com.hr.management.entities.*;
import com.hr.management.service.RhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
// import java.text.SimpleDateFormat;
// import java.util.Date;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/rh")
public class RhController {

    @Autowired
    private RhService rhService;

    // ------------------- Marquer présence -------------------
    @PostMapping("/presence")
    public Presence marquerPresence(@RequestParam String employeId,
                                    @RequestParam String mouvement) throws Exception {
        return rhService.marquerPresence(employeId, mouvement);
    }

    // ------------------- Demander congé -------------------
    @PostMapping("/conge")
    public Conge demanderConge(@RequestParam String employeId,
                               @RequestParam String typeCongeId,
                               @RequestParam String dateDebut,
                               @RequestParam String dateFin) throws Exception {
        LocalDate d1 = LocalDate.parse(dateDebut);
        LocalDate d2 = LocalDate.parse(dateFin);
        return rhService.demanderConge(employeId, typeCongeId, d1, d2);
    }

    // ------------------- Valider ou Refuser congé -------------------
    @PostMapping("/conge/{id}/statut")
    public StatutConge changerStatut(@PathVariable String id,
                                     @RequestParam String statutId) throws Exception {
        return rhService.changerStatutConge(id, statutId);
    }

    // ------------------- Lister présences -------------------
    @GetMapping("/presences/{employeId}")
    public List<Presence> getPresences(@PathVariable String employeId) {
        return rhService.getPresences(employeId);
    }

    // ------------------- Lister congés -------------------
    @GetMapping("/conges/{employeId}")
    public List<Conge> getConges(@PathVariable String employeId) {
        return rhService.getConges(employeId);
    }

    @GetMapping("/conges")
    public List<Conge> getAllConges() {
        return rhService.getAllConges();
    }

    @GetMapping("/typeconge")
    public List<TypeConge> getAllTypesConge() {
        return rhService.getTypeConges();
    }

    @GetMapping("/attente/details")
public List<CongesDTO> getCongesEnAttenteDetails() {
    return rhService.getCongesEnAttente().stream()
            .map(conge -> {
                CongesDTO dto = new CongesDTO();
                dto.setIdConge(conge.getIdConge());
                dto.setEmployeNom(conge.getEmploye().getNom());
                dto.setEmployePrenom(conge.getEmploye().getPrenom());
                dto.setTypeConge(conge.getTypeConge().getLibelle());
                dto.setDateDebut(conge.getDateDebut());
                dto.setDateFin(conge.getDateFin());
                // Statut réel (dernier statut)
                StatutConge dernierStatut = conge.getStatuts().stream()
                        .max(Comparator.comparing(StatutConge::getDateStatut))
                        .orElse(null);
                dto.setStatut(dernierStatut != null ? dernierStatut.getStatut().getLibelle() : "EN_ATTENTE");
                return dto;
            })
            .toList();
}


}
