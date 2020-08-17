package com.example.clinisystest.service;

import com.example.clinisystest.domain.Article;
import com.example.clinisystest.domain.Fournisseur;
import com.example.clinisystest.domain.Vente;
import com.example.clinisystest.repository.ArtcileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArtcileRepository artcileRepository;
    @Autowired
    private FounisseurService founisseurService;
    public Article findArticle(Long articleId){
        return artcileRepository.findByArticleId(articleId);
    }

    public Article saveArticle(Article article){
        Article newArticle = new Article();
        newArticle.setArticleName(article.getArticleName());
        newArticle.setCategorie(article.getCategorie());
        newArticle.getVentes().addAll(article.getVentes()
                .stream()
                .map(vente -> {
                    Fournisseur fournisseur = founisseurService.findFournisseur(vente.getFournisseur().getFournisseurId());
                    Vente newVente = new Vente();
                    newVente.setArticle(newArticle);
                    newVente.setFournisseur(fournisseur);
                    newVente.setPrix(vente.getPrix());
                    return  newVente;
                }).collect(Collectors.toList())
        );
        return artcileRepository.save(newArticle);
    }
}
