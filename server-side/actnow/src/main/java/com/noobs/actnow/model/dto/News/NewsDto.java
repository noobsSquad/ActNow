package com.noobs.actnow.model.dto.News;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"provider", "title", "description", "url", "image"})
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
public class NewsDto {
    
    @JsonProperty("provider")
    private List<Map<String,String>> provider;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("url")
    private String url;

    @JsonProperty("image")
    private Map<String, Map<String,String>> image;

    @JsonProperty("publishedAt")
    private String publishedAt;
}
