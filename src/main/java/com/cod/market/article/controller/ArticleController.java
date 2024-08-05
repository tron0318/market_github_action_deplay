package com.cod.market.article.controller;

import com.cod.market.article.entity.Article;
import com.cod.market.article.form.ArticleForm;
import com.cod.market.article.service.ArticleService;
import com.cod.market.product.entity.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articleList = articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);

        return "article/detail";
    }

    @GetMapping("/write")
    public String write() {
        return "article/write";
    }

    @PostMapping("/write")
    public String create(@RequestParam(value="title") String title,
                         @RequestParam(value="content") String content) {
        articleService.create(title, content);
        return "redirect:/article/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return "redirect:/";
    }


    @GetMapping("/modify/{id}")
    public String articleModify(@PathVariable("id") Long id, Model model) {
        Article article = articleService.getArticleById(id);
        ArticleForm articleForm = new ArticleForm();
        articleForm.setTitle(article.getTitle());
        articleForm.setContent(article.getContent());
        model.addAttribute("article", article);
        model.addAttribute("articleForm", articleForm);
        return "article/modify_form";
    }

    @PostMapping("/modify/{id}")
    public String articleModify(@Valid ArticleForm articleForm, BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "article/modify_form";
        }
        Article article = articleService.getArticleById(id);
        articleService.modify(article, articleForm.getTitle(), articleForm.getContent());
        return String.format("redirect:/article/detail/%s", id);
    }


}
