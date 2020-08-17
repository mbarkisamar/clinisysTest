package com.example.clinisystest.repository;

import com.example.clinisystest.domain.Article;
import com.example.clinisystest.domain.Fournisseur;
import org.springframework.data.repository.CrudRepository;

public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
    Fournisseur findByFournisseurId(Long FournisseurId);
}
