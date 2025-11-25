package com.hr.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hr.management.entities.Domaine;
import com.hr.management.repository.DomaineRepository;

@Service
public class DomaineService {
    private final DomaineRepository domaineRepository;

    public DomaineService(DomaineRepository domaineRepository) {
        this.domaineRepository= domaineRepository;
    }

    public List<Domaine> findAllDomaine(){
        return domaineRepository.findAll();
    }
}
