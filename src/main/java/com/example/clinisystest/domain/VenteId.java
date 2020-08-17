package com.example.clinisystest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VenteId implements Serializable {
private Long fournisseurId;
private Long articleId;

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VenteId)) return false;
        VenteId venteId = (VenteId) o;
        return getFournisseurId().equals(venteId.getFournisseurId()) &&
                getArticleId().equals(venteId.getArticleId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFournisseurId(), getArticleId());
    }
}
