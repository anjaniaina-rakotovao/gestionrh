package com.hr.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.hr.management.entities.DocEmploye;

import java.util.List;

public interface DocEmployeRepository extends JpaRepository<DocEmploye, String> {
    @Query("SELECT d FROM DocEmploye d WHERE d.employe.idEmploye = :idEmploye")
    List<DocEmploye> findByEmployeId(@Param("idEmploye") String idEmploye);

    // Compter par l'ID de l'employé via la relation
    @Query("SELECT COUNT(d) FROM DocEmploye d WHERE d.employe.idEmploye = :idEmploye")
    long countByEmployeId(@Param("idEmploye") String idEmploye);

    // Vérifier l'existence via la relation
    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM DocEmploye d WHERE d.employe.idEmploye = :idEmploye")
    boolean existsByEmployeId(@Param("idEmploye") String idEmploye);

    // Méthode alternative avec la relation directe
    List<DocEmploye> findByEmployeIdEmploye(String idEmploye);

}