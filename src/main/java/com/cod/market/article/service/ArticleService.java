package com.cod.market.article.service;

import com.cod.market.article.entity.Article;
import com.cod.market.article.repository.ArticleRepository;
import com.cod.market.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public void create(String title, String content) {
        Article a = new Article();
        a.setTitle(title);
        a.setContent(content);
        a.setCreateDate(LocalDateTime.now());
        articleRepository.save(a);
    }

    public Article getArticleById(Long id) {
        return articleRepository.getArticleById(id);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public void modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
        this.articleRepository.save(article);
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }
}
