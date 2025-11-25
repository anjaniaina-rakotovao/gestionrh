package com.hr.management.repository;

import com.hr.management.entities.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PresenceRepository extends JpaRepository<Presence, String> {

    // Toutes les présences d'un employé
    List<Presence> findByEmployeIdEmploye(String idEmploye);

    // Toutes les présences d'un employé pour une date précise
    List<Presence> findByEmployeIdEmployeAndDate(String idEmploye, Date date);
}
