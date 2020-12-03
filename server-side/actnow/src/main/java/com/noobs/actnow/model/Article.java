package com.noobs.actnow.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;

public class Article {
    
    @Id
    private Long id;

    private String headline;

    private String url;

    private String writtenBy;

    private Date publishedAt;
}
