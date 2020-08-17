package com.example.clinisystest.controller;

import com.example.clinisystest.service.CategorieService;
import com.example.clinisystest.service.FounisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.clinisystest.domain.*;
import com.example.clinisystest.repository.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {

    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private CategorieService categorieService;
    /*
    @GetMapping
    public Collection<Categorie> findAll() {
        return categorieRepository.findAll();
    }*/
   /* @PostMapping
    public ResponseEntity<Categorie> addCategorie( @RequestBody Categorie categorie) throws URISyntaxException {
        Categorie newCategorie = categorieRepository.save(categorie);
        return ResponseEntity.created(new URI("/api/article/" + newCategorie.getCategorieId())).body(categorie);
    }*/
    @GetMapping
    public Collection<Categorie> findAll() {
        return (Collection<Categorie>) categorieRepository.findAll();
    }
    @GetMapping("/{id}")
    public  Categorie findOne(@PathVariable Long id) {
        return categorieRepository.findByCategorieId(id);
    }
    @PostMapping
    public ResponseEntity<?> saveCategorie(@RequestBody Categorie categorie) {
        return new ResponseEntity<>(categorieRepository.save(categorie), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie categorie) {
        Categorie newCategorie = categorieRepository.save(categorie);
        return  ResponseEntity.ok(newCategorie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Long id) {
        categorieRepository.delete(categorieRepository.findByCategorieId(id));
        return ResponseEntity.ok().build();
    }

}
