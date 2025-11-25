package com.hr.management.repository;

import com.hr.management.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DomaineRepository extends JpaRepository<Domaine, Long> {
    
}
