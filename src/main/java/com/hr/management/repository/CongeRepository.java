package com.hr.management.repository;

import com.hr.management.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CongeRepository extends JpaRepository<Conge, String> {

    // Tous les congés d'un employé
    List<Conge> findByEmploye_IdEmploye(String idEmploye);

    @Query("SELECT c.idConge FROM Conge c ORDER BY c.idConge DESC LIMIT 1")
    String findLastId();

    @Query("SELECT DISTINCT c FROM Conge c LEFT JOIN FETCH c.statuts s ORDER BY s.dateStatut DESC")
    List<Conge> findAllWithStatuts();

}
