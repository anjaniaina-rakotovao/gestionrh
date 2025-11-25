package com.hr.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hr.management.dto.DocEmployeDTO;
import com.hr.management.service.DocEmployeService;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocEmployeController {
    
    private final DocEmployeService docEmployeService;
    
    public DocEmployeController(DocEmployeService docEmployeService) {
        this.docEmployeService = docEmployeService;
    }
    
    // GET tous les documents d'un employé
    @GetMapping("/employe/{idEmploye}")
    public ResponseEntity<List<DocEmployeDTO>> getDocumentsByEmploye(
            @PathVariable String idEmploye) {
        
        List<DocEmployeDTO> documents = docEmployeService.getDocumentsByEmploye(idEmploye);
        
        if (documents.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(documents);
    }
    
    // GET un document spécifique
    @GetMapping("/{idDocEmploye}")
    public ResponseEntity<DocEmployeDTO> getDocument(
            @PathVariable String idDocEmploye) {
        
        DocEmployeDTO document = docEmployeService.getDocumentById(idDocEmploye);
        
        if (document == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(document);
    }
    
    // GET vérifier si un employé a des documents
    @GetMapping("/employe/{idEmploye}/exists")
    public ResponseEntity<Boolean> hasDocuments(
            @PathVariable String idEmploye) {
        
        boolean hasDocuments = docEmployeService.hasDocuments(idEmploye);
        return ResponseEntity.ok(hasDocuments);
    }
    
    // GET nombre de documents d'un employé
    @GetMapping("/employe/{idEmploye}/count")
    public ResponseEntity<Long> countDocuments(
            @PathVariable String idEmploye) {
        
        long count = docEmployeService.countDocumentsByEmploye(idEmploye);
        return ResponseEntity.ok(count);
    }
}