package com.hr.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.management.entities.*;

public interface PosteRepository extends JpaRepository< Poste , String> {
    // Poste findById(String idPoste);
    List<Poste> findByDomaine(Domaine domaine);
}
