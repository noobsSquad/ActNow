package com.noobs.actnow.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFilter;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    
    private String id;

    private String name;

    private String url;

    Image image;

    private Map<String,String> provider;

    private String datePublished;
}
