package com.hr.management.controller;

import com.hr.management.dto.InfoEmployeDTO;
import com.hr.management.service.EmployeService1;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employe")
public class PosteEmployeController {

    private final EmployeService1 employeService;

    public PosteEmployeController(EmployeService1 employeService) {
        this.employeService = employeService;
    }

    @GetMapping("/{idEmploye}/{mois}/{annee}/PosteEmploye")
    public InfoEmployeDTO getPosteEmploye(
            @PathVariable String idEmploye,
            @PathVariable int mois,
            @PathVariable int annee) {

        return employeService.getInfoEmp(idEmploye, mois, annee);
    }
}
