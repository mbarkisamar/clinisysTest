package com.example.clinisystest.controller;

import com.example.clinisystest.domain.Article;
import com.example.clinisystest.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.clinisystest.service.FounisseurService;
import com.example.clinisystest.domain.Fournisseur;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurController {
    @Autowired
    private FounisseurService fournisseurService;
    @Autowired
    private FournisseurRepository fournisseurRepository;

    @GetMapping
    public Collection<Fournisseur> findAll() {
        return (Collection<Fournisseur>) fournisseurRepository.findAll();
    }
    @GetMapping("/{id}")
    public Fournisseur findOne(@PathVariable Long id) {
        return fournisseurRepository.findByFournisseurId(id);

    }
    @PostMapping
    public ResponseEntity<?> addFournisseur( @RequestBody Fournisseur fournisseur)  {
        return new ResponseEntity<>(fournisseurRepository.save(fournisseur), HttpStatus.CREATED);
    }
    @PostMapping(path = "/article", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveFournisseur(@RequestBody Fournisseur fournisseur) {
        return new ResponseEntity<>(fournisseurService.saveFournisseur(fournisseur), HttpStatus.CREATED);
    }


    @PutMapping
    public  ResponseEntity<Fournisseur> updateFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur newFournisseur = fournisseurRepository.save(fournisseur);
        return ResponseEntity.ok(newFournisseur);
    }


   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable Long id) {
        fournisseurRepository.delete(fournisseurService.findFournisseur(id));
        return ResponseEntity.ok().build();

    }

}
