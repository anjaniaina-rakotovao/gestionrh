package com.hr.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hr.management.entities.Employe;;

public interface EmployeRepository extends JpaRepository<Employe, String> {

    // @Query("SELECT e.idEmploye, e.nom, e.prenom, p.libelle, d.libelle FROM Employe e JOIN EmployePoste ep ON e.idEmploye = ep.employe.idEmploye JOIN Poste p ON ep.poste.idPoste = p.idPoste JOIN Domaine d ON p.domaine.idDomaine = d.idDomaine WHERE d.idDomaine = :id_domaine AND ep.dateFin IS NULL")
    @Query("SELECT e.idEmploye, e.nom, e.prenom, p.libelle, d.libelle FROM Employe e JOIN EmployePoste ep ON e.idEmploye = ep.employe.idEmploye JOIN Poste p ON ep.poste.idPoste = p.idPoste JOIN Domaine d ON p.domaine.idDomaine = d.idDomaine WHERE d.idDomaine = :id_domaine")
    List<Object[]> findEmployeByDomaine(@Param("id_domaine") String id_domaine);

    @Query("SELECT e FROM Employe e JOIN EmployePoste ep ON e.idEmploye = :idEmploye")
    Employe findEmployeByStringId(@Param("idEmploye") String idEmploye);

    @Query("SELECT e FROM Employe e WHERE " +
           "(:nom IS NULL OR LOWER(e.nom) LIKE LOWER(CONCAT('%', :nom, '%'))) AND " +
           "(:prenom IS NULL OR LOWER(e.prenom) LIKE LOWER(CONCAT('%', :prenom, '%')))")
    List<Employe> findByNomAndPrenom(@Param("nom") String nom, @Param("prenom") String prenom);

    Employe findByMail(String mail);
}
