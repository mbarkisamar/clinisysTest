package com.example.clinisystest.service;

import com.example.clinisystest.domain.Article;
import com.example.clinisystest.domain.Vente;
import com.example.clinisystest.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinisystest.domain.Fournisseur;

import java.util.stream.Collectors;

@Service
public class FounisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private ArticleService articleService;

    public Fournisseur findFournisseur(Long fournisseurId){
        return fournisseurRepository.findByFournisseurId(fournisseurId);
    }

  public Fournisseur saveFournisseur(Fournisseur fournisseur){
    Fournisseur newFournisseur = new Fournisseur();
    //newFournisseur.setFournisseurId(fournisseur.getFournisseurId());
    newFournisseur.setFournisseurName(fournisseur.getFournisseurName());
    newFournisseur.getVentes().addAll(fournisseur.getVentes()
            .stream()
            .map(vente -> {
                Article article = articleService.findArticle(vente.getArticle().getArticleId());
                Vente newVente = new Vente();
                newVente.setArticle(article);
                newVente.setFournisseur(newFournisseur);
                newVente.setPrix(vente.getPrix());
            return  newVente;
            }).collect(Collectors.toList())
    );
    return fournisseurRepository.save(newFournisseur);
  }
}
