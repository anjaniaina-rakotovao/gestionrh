package com.hr.management.service;

import com.hr.management.dto.DocEmployeDTO;
import com.hr.management.entities.DocEmploye;
import com.hr.management.repository.DocEmployeRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocEmployeService {
    
    private final DocEmployeRepository docEmployeRepository;
    
    public DocEmployeService(DocEmployeRepository docEmployeRepository) {
        this.docEmployeRepository = docEmployeRepository;
    }
    
    // Récupérer tous les documents d'un employé
    public List<DocEmployeDTO> getDocumentsByEmploye(String idEmploye) {
        List<DocEmploye> documents = docEmployeRepository.findByEmployeId(idEmploye);
        
        return documents.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Récupérer un document spécifique
    public DocEmployeDTO getDocumentById(String idDocEmploye) {
        return docEmployeRepository.findById(idDocEmploye)
                .map(this::convertToDTO)
                .orElse(null);
    }
    
    // Compter les documents d'un employé
    public long countDocumentsByEmploye(String idEmploye) {
        return docEmployeRepository.countByEmployeId(idEmploye);
    }
    
    // Vérifier si un employé a des documents
    public boolean hasDocuments(String idEmploye) {
        return docEmployeRepository.existsByEmployeId(idEmploye);
    }
    
    // Convertir Entity en DTO
    private DocEmployeDTO convertToDTO(DocEmploye docEmploye) {
        DocEmployeDTO dto = new DocEmployeDTO(
            docEmploye.getIdDocEmploye(),
            docEmploye.getEmploye().getIdEmploye(), // Récupérer l'ID de l'employé depuis la relation
            docEmploye.getImagePath()
        );
        
        // Déduire le type de document du nom de fichier
        dto.setTypeDocument(deduireTypeDocument(docEmploye.getImagePath()));
        
        return dto;
    }
    
    // Méthode pour déduire le type de document du nom de fichier
    private String deduireTypeDocument(String imagePath) {
        if (imagePath == null) return "Document";
        
        String nomFichier = imagePath.toLowerCase();
        
        if (nomFichier.contains("cv") || nomFichier.contains("curriculum")) {
            return "CV";
        } else if (nomFichier.contains("contrat")) {
            return "Contrat";
        } else if (nomFichier.contains("diplome") || nomFichier.contains("certificat")) {
            return "Diplôme";
        } else if (nomFichier.contains("carte") || nomFichier.contains("identite")) {
            return "Pièce d'identité";
        } else if (nomFichier.contains("photo")) {
            return "Photo";
        } else if (nomFichier.contains("bulletin") || nomFichier.contains("salaire")) {
            return "Bulletin de salaire";
        } else if (nomFichier.contains("attestation")) {
            return "Attestation";
        } else {
            return "Document";
        }
    }
}