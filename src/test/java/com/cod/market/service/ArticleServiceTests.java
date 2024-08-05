package com.cod.market.service;

import com.cod.market.article.service.ArticleService;
import com.cod.market.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleServiceTests {
    @Autowired
    private ArticleService articleService;

    @Test
    @DisplayName("게시글생성")
    void test1(){
        for ( int i = 1; i<= 200; i++){
            String title = String.format("제목:테스트제목[%03d]", i);
            String content = "테스트내용";
            articleService.create(title, content);
        }
    }
}
