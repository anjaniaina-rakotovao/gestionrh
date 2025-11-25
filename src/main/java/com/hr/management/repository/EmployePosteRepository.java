package com.hr.management.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hr.management.entities.EmployePoste;

public interface EmployePosteRepository extends JpaRepository<EmployePoste, String> {
    @Query("SELECT ep FROM EmployePoste ep WHERE ep.employe.id=:idEmploye AND ep.dateDebut<=:date AND (ep.dateFin IS NULL OR ep.dateFin >= :date)")
    Optional<EmployePoste> findEmployePosteAtDate(
            @Param("idEmploye") String idEmploye,
            @Param("date") LocalDate date);

}