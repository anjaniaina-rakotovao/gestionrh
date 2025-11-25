package com.hr.management.repository;

import com.hr.management.entities.StatutConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatutCongeRepository extends JpaRepository<StatutConge, String> {

    // Tous les statuts d'un congé
    List<StatutConge> findByCongeIdConge(String idConge);

    @Query(value = "SELECT id_statut_conge FROM statut_conge WHERE id_conge = :idConge ORDER BY id_statut_conge DESC LIMIT 1", nativeQuery = true)
    String findLastIdByConge(String idConge);

}
