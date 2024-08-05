package com.cod.market.article.entity;

import com.cod.market.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String title;
    private String content;



    @CreatedDate
    private LocalDateTime createDate;


}
