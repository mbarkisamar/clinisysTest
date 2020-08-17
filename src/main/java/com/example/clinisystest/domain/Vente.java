package com.example.clinisystest.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
public class Vente implements Serializable {
    @EmbeddedId
    private VenteId venteId = new VenteId();
    @ManyToOne
    @MapsId("fournisseurId")
    @JoinColumn
    private Fournisseur fournisseur;
    @ManyToOne
    @MapsId("articleId")
    @JoinColumn
    private Article article;
   private BigDecimal prix;

    public VenteId getVenteId() {
        return venteId;
    }

    public void setVenteId(VenteId venteId) {
        this.venteId = venteId;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
}
