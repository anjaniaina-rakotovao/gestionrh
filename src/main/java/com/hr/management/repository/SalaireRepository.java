package com.hr.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.management.entities.Poste;
import com.hr.management.entities.Salaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalaireRepository extends JpaRepository< Salaire , Integer> {
     List<Salaire> findByPoste(Poste poste);
     @Query("SELECT s FROM Salaire s WHERE s.poste.idPoste = :idPoste")
     Optional<Salaire> findByPosteId(@Param("idPoste") String idPoste);
}
