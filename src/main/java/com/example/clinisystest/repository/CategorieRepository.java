package com.example.clinisystest.repository;

import com.example.clinisystest.domain.Article;
import com.example.clinisystest.domain.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    Categorie findByCategorieId(Long categorieId);
}
