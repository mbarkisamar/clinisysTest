package com.example.clinisystest.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import com.fasterxml.jackson.annotation.*;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Fournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fournisseurId;
    private String fournisseurName;
    @OneToMany(mappedBy = "fournisseur" , cascade = CascadeType.ALL)
    private Collection<Vente> ventes= new ArrayList<>();

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public String getFournisseurName() {
        return fournisseurName;
    }

    public void setFournisseurName(String fournisseurName) {
        this.fournisseurName = fournisseurName;
    }

    public Collection<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(Collection<Vente> ventes) {
        this.ventes = ventes;
    }
}
