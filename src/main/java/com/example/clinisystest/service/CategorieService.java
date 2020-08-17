package com.example.clinisystest.service;

import com.example.clinisystest.domain.Article;
import com.example.clinisystest.domain.Categorie;
import com.example.clinisystest.domain.Fournisseur;
import com.example.clinisystest.domain.Vente;
import com.example.clinisystest.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private ArticleService articleService;

    public Categorie saveCategorie(Categorie categorie){
        Categorie newCategorie= new Categorie();
        newCategorie.setCategorieName(categorie.getCategorieName());
        newCategorie.setArticles(categorie.getArticles());
        return categorieRepository.save(newCategorie);
    }
}
