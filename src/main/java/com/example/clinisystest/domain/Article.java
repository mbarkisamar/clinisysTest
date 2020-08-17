package com.example.clinisystest.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private String articleName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @JsonBackReference
    private Categorie categorie;
    @OneToMany(mappedBy = "article" , cascade = CascadeType.ALL)

    private Collection<Vente> ventes= new ArrayList<>();

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Collection<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(Collection<Vente> ventes) {
        this.ventes = ventes;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
