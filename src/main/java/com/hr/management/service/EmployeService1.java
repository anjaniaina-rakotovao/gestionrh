package com.hr.management.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hr.management.dto.InfoEmployeDTO;
import com.hr.management.entities.Employe;
import com.hr.management.entities.EmployePoste;
import com.hr.management.repository.EmployePosteRepository;
import com.hr.management.repository.EmployeRepository;

@Service
public class EmployeService1 {
    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private EmployePosteRepository employePosteRepository;

    public InfoEmployeDTO getInfoEmp(String idEmploye, int mois, int annee) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));

        LocalDate date = LocalDate.of(annee, mois, 1);

        EmployePoste poste = employePosteRepository.findEmployePosteAtDate(idEmploye, date)
                .orElse(null);

        String posteLibelle = (poste != null && poste.getPoste() != null) ? poste.getPoste().getLibelle() : "N/A";

        return new InfoEmployeDTO(employe.getNom(), employe.getPrenom(), posteLibelle);
    }

}
