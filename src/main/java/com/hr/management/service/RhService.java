package com.hr.management.service;

import com.hr.management.entities.*;
import com.hr.management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RhService {

    @Autowired
    private EmployeRepository employeRepo;

    @Autowired
    private PresenceRepository presenceRepo;

    @Autowired
    private CongeRepository congeRepo;

    @Autowired
    private StatutCongeRepository statutCongeRepo;

    @Autowired
    private StatutRepository statutRepo;

    @Autowired
    private TypeCongeRepository typeCongeRepository;

    // ------------------- Marquer présence -------------------
    public Presence marquerPresence(String employeId, String mouvement) throws Exception {
        Optional<Employe> employeOpt = employeRepo.findById(employeId);
        if (!employeOpt.isPresent()) {
            throw new Exception("Employé non trouvé");
        }
        Presence p = new Presence();
        p.setIdPresence(java.util.UUID.randomUUID().toString());
        p.setEmploye(employeOpt.get());
        p.setMouvement(mouvement);
        p.setDate(new Date());
        return presenceRepo.save(p);
    }

    // ------------------- Demander congé -------------------
    public Conge demanderConge(String employeId, String typeCongeId, LocalDate debut, LocalDate fin) throws Exception {
        Optional<Employe> employeOpt = employeRepo.findById(employeId);
        if (!employeOpt.isPresent())
            throw new Exception("Employé non trouvé");

        Conge conge = new Conge();
        conge.setIdConge(generateNextIdConge());
        conge.setEmploye(employeOpt.get());
        TypeConge type = new TypeConge();
        type.setIdTypeConge(typeCongeId);
        conge.setTypeConge(type);
        conge.setDateDebut(debut);
        conge.setDateFin(fin);
        conge = congeRepo.save(conge);

        // Initialiser statut : EN_ATTENTE
        Statut statutEnAttente = statutRepo.findById("STAT-DEM").orElse(null);
        if (statutEnAttente != null) {
            StatutConge sc = new StatutConge();
            sc.setIdStatutConge(generateNextStatutCongeId(conge.getIdConge()));
            sc.setConge(conge);
            sc.setStatut(statutEnAttente);
            sc.setDateStatut(LocalDate.now());
            statutCongeRepo.save(sc);
        }

        return conge;
    }

    public String generateNextIdConge() {
        String lastId = congeRepo.findLastId(); // ex : CONG-006
        if (lastId == null) {
            return "CONG-001";
        }

        int number = Integer.parseInt(lastId.split("-")[1]); // 6
        number++; // 7

        return String.format("CONG-%03d", number); // CONG-007
    }

    public String generateNextStatutCongeId(String idConge) {

        String lastId = statutCongeRepo.findLastIdByConge(idConge);
        // lastId exemple : "STCG-006-1"

        // Extraire numéro du congé
        String numericConge = idConge.split("-")[1]; // "006"

        if (lastId == null) {
            return "STCG-" + numericConge + "-1";
        }

        // Récupérer le dernier numéro
        int lastNum = Integer.parseInt(lastId.split("-")[2]); // ex : 1
        int newNum = lastNum + 1;

        return "STCG-" + numericConge + "-" + newNum;
    }

    // ------------------- Valider ou Refuser congé -------------------
    public StatutConge changerStatutConge(String congeId, String statutId) throws Exception {
        Optional<Conge> congeOpt = congeRepo.findById(congeId);
        Optional<Statut> statutOpt = statutRepo.findById(statutId);
        if (!congeOpt.isPresent() || !statutOpt.isPresent())
            throw new Exception("Conge ou Statut introuvable");

        StatutConge sc = new StatutConge();
        sc.setIdStatutConge(generateNextStatutCongeId(congeId));
        sc.setConge(congeOpt.get());
        sc.setStatut(statutOpt.get());
        sc.setDateStatut(LocalDate.now());
        return statutCongeRepo.save(sc);
    }

    // ------------------- Lister présences d'un employé -------------------
    public List<Presence> getPresences(String employeId) {
        // return presenceRepo.findByEmployeIdEmployeAndDate(employeId, null);
        return presenceRepo.findByEmployeIdEmploye(employeId);
    }

    // ------------------- Lister congés d'un employé -------------------
    public List<Conge> getConges(String employeId) {
        return congeRepo.findByEmploye_IdEmploye(employeId);
    }

    public List<Conge> getAllConges() {
        return congeRepo.findAll();
    }

    public List<TypeConge> getTypeConges() {
        return typeCongeRepository.findAll();
    }

    public List<Conge> getCongesEnAttente() {
        return congeRepo.findAllWithStatuts().stream()
                .filter(conge -> {
                    if (conge.getStatuts().isEmpty())
                        return false;

                    StatutConge dernierStatut = conge.getStatuts().get(0); // Déjà trié par date DESC
                    return "STAT-DEM".equals(dernierStatut.getStatut().getIdStatut());
                })
                .toList();
    }

}
