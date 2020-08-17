package com.example.clinisystest.repository;
import com.example.clinisystest.domain.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArtcileRepository extends CrudRepository<Article, Long>{
    Article findByArticleId(Long articleId);
}
