package com.cod.market.article.repository;

import com.cod.market.article.entity.Article;
import com.cod.market.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article getArticleById(Long id);
}
