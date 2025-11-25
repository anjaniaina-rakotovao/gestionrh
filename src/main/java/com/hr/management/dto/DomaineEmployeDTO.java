package com.hr.management.dto;

import java.util.List;

// Assurez-vous d'utiliser le bon package (ex: com.hr.management.dto)
public class DomaineEmployeDTO {
    private String idDomaine;
    private String libelleDomaine;
    private List<EmployeDTO> employes;

    public DomaineEmployeDTO(String idDomaine, String libelleDomaine, List<EmployeDTO> employes) {
        this.idDomaine = idDomaine;
        this.libelleDomaine = libelleDomaine;
        this.employes = employes;
    }

    public String getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(String idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getLibelleDomaine() {
        return libelleDomaine;
    }

    public void setLibelleDomaine(String libelleDomaine) {
        this.libelleDomaine = libelleDomaine;
    }

    public List<EmployeDTO> getEmployes() {
        return employes;
    }

    public void setEmployes(List<EmployeDTO> employes) {
        this.employes = employes;
    }

}
