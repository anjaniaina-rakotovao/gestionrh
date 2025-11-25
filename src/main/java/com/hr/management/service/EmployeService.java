package com.hr.management.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hr.management.dto.AlerteRHDTO;
import com.hr.management.dto.ContratDTO;
import com.hr.management.dto.CritereRechercheEmploye;
import com.hr.management.dto.DomaineEmployeDTO;
import com.hr.management.dto.EmployeDTO;
import com.hr.management.dto.EmployeDetailsDTO;
import com.hr.management.dto.EmployePosteDTO;
import com.hr.management.dto.EmployeRechercheDTO;
import com.hr.management.dto.PosteDTO;
import com.hr.management.dto.StatistiqueContratDTO;
import com.hr.management.dto.StatistiqueDemographiqueDTO;
import com.hr.management.dto.StatistiquePosteDTO;
import com.hr.management.dto.StatistiqueTurnoverDTO;
import com.hr.management.dto.StatistiqueTurnoverPosteDTO;
import com.hr.management.entities.Contrat;
import com.hr.management.entities.Domaine;
import com.hr.management.entities.Employe;
import com.hr.management.entities.EmployePoste;
import com.hr.management.entities.HistoMouvement;
import com.hr.management.entities.Poste;
import com.hr.management.repository.DomaineRepository;
import com.hr.management.repository.EmployeRepository;
import com.hr.management.repository.PosteRepository;
import com.hr.management.repository.SalaireRepository;

@Service
public class EmployeService {
        private final EmployeRepository employeRepository;
        private final DomaineRepository domaineRepository;
        private final SalaireRepository salaireRepository;
        private final PosteRepository posteRepository;

        public EmployeService(EmployeRepository employeRepository,
                        DomaineRepository domaineRepository,
                        SalaireRepository salaireRepository,
                        PosteRepository posteRepository) {
                this.employeRepository = employeRepository;
                this.domaineRepository = domaineRepository;
                this.salaireRepository = salaireRepository;
                this.posteRepository = posteRepository;
        }

        public List<DomaineEmployeDTO> findEmployeByDomaine() {
                List<Domaine> listeDomaines = domaineRepository.findAll();
                List<DomaineEmployeDTO> listeEmployes = new ArrayList<>();
                for (Domaine domaine : listeDomaines) {
                        List<Object[]> listeEmployeDomaine = employeRepository
                                        .findEmployeByDomaine(domaine.getIdDomaine());
                        List<EmployeDTO> listeEmployesDomaineDTO = listeEmployeDomaine.stream()
                                        .map(data -> new EmployeDTO(
                                                        (String) data[0],
                                                        (String) data[1],
                                                        (String) data[2],
                                                        (String) data[3]))
                                        .toList();

                        DomaineEmployeDTO domaineEmployeDTO = new DomaineEmployeDTO(domaine.getIdDomaine(),
                                        domaine.getLibelle(),
                                        listeEmployesDomaineDTO);
                        listeEmployes.add(domaineEmployeDTO);
                }
                return listeEmployes;
        }

        public EmployeDetailsDTO getEmployeDetails(String idEmploye) {
                Employe employe = employeRepository.findEmployeByStringId(idEmploye);

                List<ContratDTO> contratDTOs = employe.getContrats() != null
                                ? employe.getContrats().stream()
                                                .map(c -> new ContratDTO(
                                                                c.getIdContrat(),
                                                                c.getTypeContrat().getLibelle(),
                                                                c.getDateDebut(),
                                                                c.getDateFin(),
                                                                c.getDuree()))
                                                .toList()
                                : new ArrayList<>();

                List<EmployePosteDTO> posteDTOs = employe.getEmployePostes() != null
                                ? employe.getEmployePostes().stream()
                                                .map(ep -> new EmployePosteDTO(
                                                                ep.getIdEmployePoste(),
                                                                ep.getPoste().getLibelle(),
                                                                ep.getPoste().getDomaine().getLibelle(),
                                                                ep.getDateDebut(),
                                                                ep.getDateFin(),
                                                                ep.getDateFin() == null))
                                                .toList()
                                : new ArrayList<>();

                return new EmployeDetailsDTO(
                                employe.getIdEmploye(),
                                employe.getNom(),
                                employe.getPrenom(),
                                employe.getDateNaissance(),
                                employe.getMail(),
                                employe.getAdresse(),
                                employe.getContact(),
                                employe.getImagePath(),
                                employe.getSexe().getLibelle(),
                                contratDTOs,
                                posteDTOs);
        }

        public List<Employe> searchEmployes(CritereRechercheEmploye criteria) {
                List<Employe> employes = employeRepository.findAll();

                if (criteria.getNom() != null && !criteria.getNom().isEmpty()) {
                        employes = employes.stream()
                                        .filter(e -> e.getNom() != null
                                                        && e.getNom().toLowerCase()
                                                                        .contains(criteria.getNom().toLowerCase()))
                                        .collect(Collectors.toList());
                }

                if (criteria.getPrenom() != null && !criteria.getPrenom().isEmpty()) {
                        employes = employes.stream()
                                        .filter(e -> e.getPrenom() != null
                                                        && e.getPrenom().toLowerCase()
                                                                        .contains(criteria.getPrenom().toLowerCase()))
                                        .collect(Collectors.toList());
                }

                if (criteria.getDomaine() != null && !criteria.getDomaine().isEmpty()) {
                        employes = employes.stream()
                                        .filter(e -> e.getEmployePostes() != null && e.getEmployePostes().stream()
                                                        .anyMatch(ep -> ep.getPoste() != null
                                                                        && ep.getPoste().getDomaine() != null &&
                                                                        ep.getPoste().getDomaine().getLibelle()
                                                                                        .equalsIgnoreCase(criteria
                                                                                                        .getDomaine())))
                                        .collect(Collectors.toList());
                }

                if (criteria.getPoste() != null && !criteria.getPoste().isEmpty()) {
                        employes = employes.stream()
                                        .filter(e -> e.getEmployePostes() != null && e.getEmployePostes().stream()
                                                        .anyMatch(ep -> ep.getPoste() != null &&
                                                                        ep.getPoste().getLibelle()
                                                                                        .equalsIgnoreCase(criteria
                                                                                                        .getPoste())))
                                        .collect(Collectors.toList());
                }

                if (criteria.getAgeMin() != null || criteria.getAgeMax() != null) {
                        employes = employes.stream()
                                        .filter(e -> {
                                                int age = calculateAge(e.getDateNaissance());
                                                boolean meetsMin = criteria.getAgeMin() == null
                                                                || age >= criteria.getAgeMin();
                                                boolean meetsMax = criteria.getAgeMax() == null
                                                                || age <= criteria.getAgeMax();
                                                return meetsMin && meetsMax;
                                        })
                                        .collect(Collectors.toList());
                }

                // Appliquer le tri
                if (criteria.getSortBy() != null && !criteria.getSortBy().isEmpty()) {
                        employes = sortEmployes(employes, criteria.getSortBy(), criteria.getSortDirection());
                }

                return employes;
        }

        public List<EmployeRechercheDTO> searchEmployesDTO(CritereRechercheEmploye criteria) {
                List<Employe> employes = searchEmployes(criteria);
                return employes.stream()
                                .map(e -> new EmployeRechercheDTO(
                                                e.getIdEmploye(),
                                                e.getNom(),
                                                e.getPrenom(),
                                                getDomainePrincipal(e),
                                                getPostePrincipal(e),
                                                calculateAge(e.getDateNaissance())))
                                .collect(Collectors.toList());
        }

        private String getPostePrincipal(Employe employe) {
                if (employe == null || employe.getEmployePostes() == null || employe.getEmployePostes().isEmpty()) {
                        return "";
                }
                return employe.getEmployePostes().stream()
                                .filter(ep -> ep != null && ep.getDateFin() == null && ep.getPoste() != null)
                                .findFirst()
                                .map(ep -> ep.getPoste().getLibelle())
                                .orElse("");
        }

        private List<Employe> sortEmployes(List<Employe> employes, String sortBy, String sortDirection) {
                boolean isAsc = sortDirection == null || sortDirection.equalsIgnoreCase("ASC");

                switch (sortBy.toLowerCase()) {
                        case "domaine" -> employes.sort((e1, e2) -> {
                                String d1 = getDomainePrincipal(e1);
                                String d2 = getDomainePrincipal(e2);
                                return isAsc ? d1.compareTo(d2) : d2.compareTo(d1);
                        });
                        case "age" -> employes.sort((e1, e2) -> {
                                int age1 = calculateAge(e1.getDateNaissance());
                                int age2 = calculateAge(e2.getDateNaissance());
                                return isAsc ? Integer.compare(age1, age2) : Integer.compare(age2, age1);
                        });
                        case "anciennete" -> employes.sort((e1, e2) -> {
                                LocalDate d1 = getDateEmbaucheEarliest(e1);
                                LocalDate d2 = getDateEmbaucheEarliest(e2);
                                return isAsc ? d1.compareTo(d2) : d2.compareTo(d1);
                        });
                }

                return employes;
        }

        private int calculateAge(LocalDate dateNaissance) {
                if (dateNaissance == null)
                        return 0;
                return Period.between(dateNaissance, LocalDate.now()).getYears();
        }

        private String getDomainePrincipal(Employe employe) {
                if (employe == null || employe.getEmployePostes() == null || employe.getEmployePostes().isEmpty()) {
                        return "";
                }
                return employe.getEmployePostes().stream()
                                .filter(ep -> ep != null && ep.getDateFin() == null && ep.getPoste() != null &&
                                                ep.getPoste().getDomaine() != null)
                                .findFirst()
                                .map(ep -> ep.getPoste().getDomaine().getLibelle())
                                .orElse("");
        }

        private LocalDate getDateEmbaucheEarliest(Employe employe) {
                if (employe == null || employe.getEmployePostes() == null || employe.getEmployePostes().isEmpty()) {
                        return LocalDate.now();
                }
                return employe.getEmployePostes().stream()
                                .map(EmployePoste::getDateDebut)
                                .filter(date -> date != null)
                                .min(LocalDate::compareTo)
                                .orElse(LocalDate.now());
        }

        public StatistiqueDemographiqueDTO getStatistiqueDemographique(int annee, int mois) {
                LocalDate dateDebut = LocalDate.of(annee, mois, 1);
                LocalDate dateFin = dateDebut.plusMonths(1).minusDays(1);
                YearMonth periode = YearMonth.of(annee, mois);

                // Récupérer tous les employés avec contrats actifs ce mois
                List<Employe> employes = employeRepository.findAll().stream()
                                .filter(e -> e.getContrats() != null && e.getContrats().stream()
                                                .anyMatch(c -> !c.getDateDebut().isAfter(dateFin) &&
                                                                (c.getDateFin() == null || !c.getDateFin()
                                                                                .isBefore(dateDebut))))
                                .collect(Collectors.toList());

                int totalEmployes = employes.size();
                int nombreHommes = (int) employes.stream()
                                .filter(e -> e.getSexe() != null && e.getSexe().getIdSexe().equals("S-H"))
                                .count();
                int nombreFemmes = totalEmployes - nombreHommes;

                // Compter par catégorie d'âge
                int age18_20 = (int) employes.stream()
                                .filter(e -> {
                                        int age = calculateAge(e.getDateNaissance());
                                        return age >= 18 && age < 20;
                                })
                                .count();

                int age20_40 = (int) employes.stream()
                                .filter(e -> {
                                        int age = calculateAge(e.getDateNaissance());
                                        return age >= 20 && age < 40;
                                })
                                .count();

                int age40_60 = (int) employes.stream()
                                .filter(e -> {
                                        int age = calculateAge(e.getDateNaissance());
                                        return age >= 40 && age < 60;
                                })
                                .count();

                int age60Plus = (int) employes.stream()
                                .filter(e -> {
                                        int age = calculateAge(e.getDateNaissance());
                                        return age >= 60;
                                })
                                .count();

                return new StatistiqueDemographiqueDTO(
                                periode, totalEmployes, nombreHommes, nombreFemmes,
                                age18_20, age20_40, age40_60, age60Plus);
        }

        // Version pour l'année entière
        public List<StatistiqueDemographiqueDTO> getStatistiquesAnnuelles(int annee) {
                List<StatistiqueDemographiqueDTO> statistiques = new ArrayList<>();
                for (int mois = 1; mois <= 12; mois++) {
                        statistiques.add(getStatistiqueDemographique(annee, mois));
                }
                return statistiques;
        }

        // Version pour tous les mois (depuis le premier employé)
        public List<StatistiqueDemographiqueDTO> getToutesStatistiques() {
                List<Employe> employes = employeRepository.findAll();
                if (employes.isEmpty()) {
                        return new ArrayList<>();
                }

                LocalDate dateMin = employes.stream()
                                .flatMap(e -> e.getContrats().stream())
                                .map(c -> c.getDateDebut())
                                .min(LocalDate::compareTo)
                                .orElse(LocalDate.now());

                LocalDate dateMax = LocalDate.now();
                List<StatistiqueDemographiqueDTO> statistiques = new ArrayList<>();

                for (LocalDate date = dateMin; !date.isAfter(dateMax); date = date.plusMonths(1)) {
                        statistiques.add(getStatistiqueDemographique(date.getYear(), date.getMonthValue()));
                }

                return statistiques;
        }

        public StatistiqueDemographiqueDTO getStatistiqueAnnuelleGlobale(int annee) {
                LocalDate dateDebut = LocalDate.of(annee, 1, 1);
                LocalDate dateFin = LocalDate.of(annee, 12, 31);
                YearMonth periode = YearMonth.of(annee, 1);

                List<Employe> employes = employeRepository.findAll().stream()
                                .filter(e -> e.getContrats() != null && e.getContrats().stream()
                                                .anyMatch(c -> !c.getDateDebut().isAfter(dateFin) &&
                                                                (c.getDateFin() == null || !c.getDateFin()
                                                                                .isBefore(dateDebut))))
                                .collect(Collectors.toList());

                int totalEmployes = employes.size();
                int nombreHommes = (int) employes.stream()
                                .filter(e -> e.getSexe() != null && e.getSexe().getIdSexe().equals("S-H"))
                                .count();
                int nombreFemmes = totalEmployes - nombreHommes;

                int age18_20 = (int) employes.stream()
                                .filter(e -> {
                                        int age = calculateAge(e.getDateNaissance());
                                        return age >= 18 && age < 20;
                                })
                                .count();

                int age20_40 = (int) employes.stream()
                                .filter(e -> {
                                        int age = calculateAge(e.getDateNaissance());
                                        return age >= 20 && age < 40;
                                })
                                .count();

                int age40_60 = (int) employes.stream()
                                .filter(e -> {
                                        int age = calculateAge(e.getDateNaissance());
                                        return age >= 40 && age < 60;
                                })
                                .count();

                int age60Plus = (int) employes.stream()
                                .filter(e -> {
                                        int age = calculateAge(e.getDateNaissance());
                                        return age >= 60;
                                })
                                .count();

                return new StatistiqueDemographiqueDTO(
                                periode, totalEmployes, nombreHommes, nombreFemmes,
                                age18_20, age20_40, age40_60, age60Plus);
        }

        public StatistiqueContratDTO getStatistiqueContrat(int annee, int mois) {
                LocalDate dateDebut = LocalDate.of(annee, mois, 1);
                LocalDate dateFin = dateDebut.plusMonths(1).minusDays(1);
                YearMonth periode = YearMonth.of(annee, mois);

                // Récupérer tous les contrats actifs ce mois
                List<Employe> employes = employeRepository.findAll();
                List<Contrat> contratsActifs = new ArrayList<>();

                for (Employe emp : employes) {
                        if (emp.getContrats() != null) {
                                for (Contrat c : emp.getContrats()) {
                                        // Vérifier si le contrat était actif ce mois
                                        if (!c.getDateDebut().isAfter(dateFin) &&
                                                        (c.getDateFin() == null
                                                                        || !c.getDateFin().isBefore(dateDebut))) {
                                                contratsActifs.add(c);
                                        }
                                }
                        }
                }

                int totalContrats = contratsActifs.size();

                int nombreCDI = (int) contratsActifs.stream()
                                .filter(c -> c.getTypeContrat() != null
                                                && c.getTypeContrat().getIdTypeContrat().equals("TCO-CDI"))
                                .count();

                int nombreCDD = (int) contratsActifs.stream()
                                .filter(c -> c.getTypeContrat() != null
                                                && c.getTypeContrat().getIdTypeContrat().equals("TCO-CDD"))
                                .count();

                int nombreApprentissage = (int) contratsActifs.stream()
                                .filter(c -> c.getTypeContrat() != null
                                                && c.getTypeContrat().getIdTypeContrat().equals("TCO-APPR"))
                                .count();

                return new StatistiqueContratDTO(
                                periode, totalContrats, nombreCDI, nombreCDD, nombreApprentissage);
        }

        // Statistiques par mois pour une année
        public List<StatistiqueContratDTO> getStatistiquesContratAnnees(int annee) {
                List<StatistiqueContratDTO> statistiques = new ArrayList<>();
                for (int mois = 1; mois <= 12; mois++) {
                        statistiques.add(getStatistiqueContrat(annee, mois));
                }
                return statistiques;
        }

        // Statistique GLOBALE pour toute l'année
        public StatistiqueContratDTO getStatistiqueContratAnnuelleGlobale(int annee) {
                LocalDate dateDebut = LocalDate.of(annee, 1, 1);
                LocalDate dateFin = LocalDate.of(annee, 12, 31);
                YearMonth periode = YearMonth.of(annee, 1);

                // Récupérer tous les contrats actifs cette année
                List<Employe> employes = employeRepository.findAll();
                List<Contrat> contratsActifs = new ArrayList<>();

                for (Employe emp : employes) {
                        if (emp.getContrats() != null) {
                                for (Contrat c : emp.getContrats()) {
                                        if (!c.getDateDebut().isAfter(dateFin) &&
                                                        (c.getDateFin() == null
                                                                        || !c.getDateFin().isBefore(dateDebut))) {
                                                contratsActifs.add(c);
                                        }
                                }
                        }
                }

                int totalContrats = contratsActifs.size();

                int nombreCDI = (int) contratsActifs.stream()
                                .filter(c -> c.getTypeContrat() != null
                                                && c.getTypeContrat().getIdTypeContrat().equals("TCO-CDI"))
                                .count();

                int nombreCDD = (int) contratsActifs.stream()
                                .filter(c -> c.getTypeContrat() != null
                                                && c.getTypeContrat().getIdTypeContrat().equals("TCO-CDD"))
                                .count();

                int nombreApprentissage = (int) contratsActifs.stream()
                                .filter(c -> c.getTypeContrat() != null
                                                && c.getTypeContrat().getIdTypeContrat().equals("TCO-APPR"))
                                .count();

                return new StatistiqueContratDTO(
                                periode, totalContrats, nombreCDI, nombreCDD, nombreApprentissage);
        }

        public List<StatistiquePosteDTO> getStatistiqueParPoste() {
                List<Poste> postes = posteRepository.findAll();
                List<StatistiquePosteDTO> statistiques = new ArrayList<>();

                for (Poste poste : postes) {
                        // Employés actuels au poste
                        List<Employe> employesActuels = employeRepository.findAll().stream()
                                        .filter(e -> e.getEmployePostes() != null && e.getEmployePostes().stream()
                                                        .anyMatch(ep -> ep.getPoste().getIdPoste()
                                                                        .equals(poste.getIdPoste()) &&
                                                                        ep.getDateFin() == null))
                                        .collect(Collectors.toList());

                        // Nombre de changements (nombre d'employés qui ont quitté ce poste)
                        int nombreChangements = (int) employeRepository.findAll().stream()
                                        .filter(e -> e.getEmployePostes() != null && e.getEmployePostes().stream()
                                                        .anyMatch(ep -> ep.getPoste().getIdPoste()
                                                                        .equals(poste.getIdPoste()) &&
                                                                        ep.getDateFin() != null))
                                        .count();

                        // Salaire moyen
                        double salaireMoyen = salaireRepository.findByPoste(poste).stream()
                                        .mapToDouble(s -> s.getMontant().doubleValue())
                                        .average()
                                        .orElse(0.0);

                        // Ancienneté moyenne
                        double ancienneteteMoyenne = employesActuels.stream()
                                        .flatMap(e -> e.getEmployePostes().stream()
                                                        .filter(ep -> ep.getPoste().getIdPoste()
                                                                        .equals(poste.getIdPoste())))
                                        .mapToDouble(ep -> Period.between(ep.getDateDebut(), LocalDate.now()).getDays()
                                                        / 365.0)
                                        .average()
                                        .orElse(0.0);

                        List<String> nomEmployes = employesActuels.stream()
                                        .map(e -> e.getNom() + " " + e.getPrenom())
                                        .collect(Collectors.toList());

                        statistiques.add(new StatistiquePosteDTO(
                                        poste.getIdPoste(),
                                        poste.getLibelle(),
                                        poste.getDomaine().getLibelle(),
                                        employesActuels.size(),
                                        salaireMoyen,
                                        ancienneteteMoyenne,
                                        nombreChangements,
                                        nomEmployes));
                }

                return statistiques;
        }

        public StatistiqueTurnoverDTO getStatistiqueTurnover(int annee, int mois) {
                LocalDate dateDebut = LocalDate.of(annee, mois, 1);
                LocalDate dateFin = dateDebut.plusMonths(1).minusDays(1);
                YearMonth periode = YearMonth.of(annee, mois);

                // Nombre de départs (contrats qui se terminent ce mois)
                int nombreDeparts = (int) employeRepository.findAll().stream()
                                .flatMap(e -> e.getContrats().stream())
                                .filter(c -> c.getDateFin() != null && !c.getDateFin().isBefore(dateDebut)
                                                && !c.getDateFin().isAfter(dateFin))
                                .count();

                // Effectif moyen
                int effectifMoyen = employeRepository.findAll().size();

                // Jours absence totaux
                int joursAbsenceTotaux = (int) employeRepository.findAll().stream()
                                .flatMap(e -> e.getHistoMouvements().stream())
                                .filter(hm -> !hm.getDate().isBefore(dateDebut) && !hm.getDate().isAfter(dateFin))
                                .mapToInt(HistoMouvement::getAbsence)
                                .sum();

                // Jours ouvrables (22 jours par mois en moyenne)
                // int joursOuvrables = 22;

                // Ancienneté moyenne
                double ancienneteteMoyenne = employeRepository.findAll().stream()
                                .filter(e -> e.getEmployePostes() != null && !e.getEmployePostes().isEmpty())
                                .mapToDouble(e -> {
                                        LocalDate dateEmbauche = e.getEmployePostes().stream()
                                                        .map(EmployePoste::getDateDebut)
                                                        .min(LocalDate::compareTo)
                                                        .orElse(LocalDate.now());

                                        return Period.between(dateEmbauche, LocalDate.now()).toTotalMonths();
                                })
                                .average()
                                .orElse(0.0);

                // Congés
                int congesPris = (int) employeRepository.findAll().stream()
                                .flatMap(e -> e.getConges().stream())
                                .filter(c -> !c.getDateDebut().isBefore(dateDebut)
                                                && !c.getDateDebut().isAfter(dateFin))
                                .count();

                int congesNonPris = 0; // À calculer selon votre logique métier

                return new StatistiqueTurnoverDTO(
                                periode, nombreDeparts, effectifMoyen,
                                joursAbsenceTotaux, 0,
                                ancienneteteMoyenne, congesNonPris, congesPris);
        }

        public AlerteRHDTO getAlertes() {
                LocalDate maintenant = LocalDate.now();
                LocalDate dans30Jours = maintenant.plusDays(30);
                LocalDate dans60Jours = maintenant.plusDays(60);

                // Alertes contrats
                List<AlerteRHDTO.AlerteContratDTO> alertesContrats = employeRepository.findAll().stream()
                                .flatMap(e -> e.getContrats().stream()
                                                .filter(c -> c.getDateFin() != null
                                                                && c.getDateFin().isAfter(maintenant))
                                                .map(c -> {
                                                        long joursRestants = ChronoUnit.DAYS.between(maintenant,
                                                                        c.getDateFin());
                                                        String severite = joursRestants < 30 ? "URGENT"
                                                                        : joursRestants < 60 ? "ATTENTION" : "INFO";
                                                        return new AlerteRHDTO.AlerteContratDTO(
                                                                        e.getIdEmploye(),
                                                                        e.getNom() + " " + e.getPrenom(),
                                                                        c.getTypeContrat().getLibelle(),
                                                                        c.getDateFin(),
                                                                        (int) joursRestants,
                                                                        severite);
                                                }))
                                .collect(Collectors.toList());

                // Alertes congés (simplifié)
                List<AlerteRHDTO.AlerteCongeDTO> alertesCongés = new ArrayList<>();

                return new AlerteRHDTO(alertesContrats, alertesCongés);
        }

        // Turnover par poste pour un mois
        public StatistiqueTurnoverPosteDTO getTurnoverPoste(String idPoste, int annee, int mois) {
                LocalDate dateDebut = LocalDate.of(annee, mois, 1);
                LocalDate dateFin = dateDebut.plusMonths(1).minusDays(1);
                YearMonth periode = YearMonth.of(annee, mois);

                Poste poste = posteRepository.findById(idPoste).orElse(null);
                if (poste == null) {
                        return null;
                }

                // Effectif au début du mois
                int effectifDebut = (int) employeRepository.findAll().stream()
                                .filter(e -> e.getEmployePostes() != null && e.getEmployePostes().stream()
                                                .anyMatch(ep -> ep.getPoste().getIdPoste().equals(idPoste) &&
                                                                !ep.getDateDebut().isAfter(dateDebut) &&
                                                                (ep.getDateFin() == null
                                                                                || ep.getDateFin().isAfter(dateDebut))))
                                .count();

                // Effectif à la fin du mois
                int effectifFin = (int) employeRepository.findAll().stream()
                                .filter(e -> e.getEmployePostes() != null && e.getEmployePostes().stream()
                                                .anyMatch(ep -> ep.getPoste().getIdPoste().equals(idPoste) &&
                                                                !ep.getDateDebut().isAfter(dateFin) &&
                                                                (ep.getDateFin() == null
                                                                                || ep.getDateFin().isAfter(dateFin))))
                                .count();

                // Nombre de départs (contrats qui se terminent ce mois)
                int nombreDeparts = (int) employeRepository.findAll().stream()
                                .filter(e -> e.getEmployePostes() != null && e.getEmployePostes().stream()
                                                .anyMatch(ep -> ep.getPoste().getIdPoste().equals(idPoste) &&
                                                                ep.getDateFin() != null &&
                                                                !ep.getDateFin().isBefore(dateDebut) &&
                                                                !ep.getDateFin().isAfter(dateFin)))
                                .count();

                // Nombre d'arrivées (contrats qui commencent ce mois)
                int nombreArrivees = (int) employeRepository.findAll().stream()
                                .filter(e -> e.getEmployePostes() != null && e.getEmployePostes().stream()
                                                .anyMatch(ep -> ep.getPoste().getIdPoste().equals(idPoste) &&
                                                                !ep.getDateDebut().isBefore(dateDebut) &&
                                                                !ep.getDateDebut().isAfter(dateFin)))
                                .count();

                int nombreChangements = nombreDeparts + nombreArrivees;


                // CORRECTION DU CALCUL DU TURNOVER
                double tauxTurnover;
                if (effectifDebut == 0 && effectifFin == 0) {
                        // Poste vide tout le mois
                        tauxTurnover = 0;
                } else if (effectifDebut == 0) {
                        // Nouveau poste créé ce mois - pas de turnover
                        tauxTurnover = 0;
                } else if (effectifFin == 0) {
                        // Poste supprimé - turnover complet (100%)
                        tauxTurnover = 100;
                } else {
                        double effectifMoyen = (effectifDebut + effectifFin) / 2.0;
                        tauxTurnover = effectifMoyen > 0 ? (nombreDeparts / effectifMoyen) * 100 : 0;

                        tauxTurnover = Math.min(tauxTurnover, 100);
                }

                // Historique des employés au poste
                List<StatistiqueTurnoverPosteDTO.HistoriqueEmployeDTO> historique = employeRepository.findAll().stream()
                                .filter(e -> e.getEmployePostes() != null && e.getEmployePostes().stream()
                                                .anyMatch(ep -> ep.getPoste().getIdPoste().equals(idPoste)))
                                .flatMap(e -> e.getEmployePostes().stream()
                                                .filter(ep -> ep.getPoste().getIdPoste().equals(idPoste))
                                                .map(ep -> {
                                                        String statut;
                                                        if (ep.getDateFin() != null
                                                                        && !ep.getDateFin().isBefore(dateDebut)
                                                                        && !ep.getDateFin().isAfter(dateFin)) {
                                                                statut = "PARTI";
                                                        } else if (!ep.getDateDebut().isBefore(dateDebut)
                                                                        && !ep.getDateDebut().isAfter(dateFin)) {
                                                                statut = "ARRIVÉ";
                                                        } else if (ep.getDateFin() == null
                                                                        || ep.getDateFin().isAfter(dateFin)) {
                                                                statut = "ACTUEL";
                                                        } else {
                                                                statut = "HISTORIQUE";
                                                        }

                                                        return new StatistiqueTurnoverPosteDTO.HistoriqueEmployeDTO(
                                                                        e.getIdEmploye(),
                                                                        e.getNom(),
                                                                        e.getPrenom(),
                                                                        ep.getDateDebut(),
                                                                        ep.getDateFin(),
                                                                        statut);
                                                }))
                                .collect(Collectors.toList());

                return new StatistiqueTurnoverPosteDTO(
                                idPoste,
                                poste.getLibelle(),
                                poste.getDomaine().getLibelle(),
                                periode,
                                effectifDebut,
                                effectifFin,
                                nombreDeparts,
                                nombreArrivees,
                                nombreChangements,
                                tauxTurnover, // Maintenant en pourcentage correct
                                historique);
        }

        // Turnover annuel par poste
        public List<StatistiqueTurnoverPosteDTO> getTurnoverPosteAnnee(String idPoste, int annee) {
                List<StatistiqueTurnoverPosteDTO> statistiques = new ArrayList<>();
                for (int mois = 1; mois <= 12; mois++) {
                        StatistiqueTurnoverPosteDTO stat = getTurnoverPoste(idPoste, annee, mois);
                        if (stat != null) {
                                statistiques.add(stat);
                        }
                }
                return statistiques;
        }

        // Turnover pour tous les postes un mois donné
        public List<StatistiqueTurnoverPosteDTO> getTurnoverTousPostes(int annee, int mois) {
                List<Poste> postes = posteRepository.findAll();
                return postes.stream()
                                .map(p -> getTurnoverPoste(p.getIdPoste(), annee, mois))
                                .filter(stat -> stat != null)
                                .collect(Collectors.toList());
        }

        // Récupérer tous les postes uniques
        public List<PosteDTO> getAllPostes() {
                return posteRepository.findAll().stream()
                                .map(p -> new PosteDTO(p.getIdPoste(), p.getLibelle()))
                                .collect(Collectors.toList());
        }
}