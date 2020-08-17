package com.example.clinisystest.controller;

import com.example.clinisystest.domain.Article;
import com.example.clinisystest.domain.Fournisseur;
import com.example.clinisystest.repository.*;
import com.example.clinisystest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArtcileRepository artcileRepository;
    @GetMapping
    public Collection<Article> findAll() {
        return (Collection<Article>) artcileRepository.findAll();
    }
    @GetMapping("/{id}")
    public Article getOne(@PathVariable Long id) {
        return artcileRepository.findByArticleId(id);
    }
    @PostMapping
    public ResponseEntity<?> addArticle( @RequestBody Article article) throws URISyntaxException {
        return new ResponseEntity<>(artcileRepository.save(article), HttpStatus.CREATED);
    }
    @PostMapping(path = "/fournisseur", consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> saveArticle(@RequestBody Article article) {
        return new ResponseEntity<>(articleService.saveArticle(article), HttpStatus.CREATED);
    }
    @PutMapping
    public  ResponseEntity<Article> updateArticle(@RequestBody Article article){
        Article newArticle = artcileRepository.save(article);
        return ResponseEntity.ok(newArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        artcileRepository.delete(artcileRepository.findByArticleId(id));
        return ResponseEntity.ok().build();

   }
}
