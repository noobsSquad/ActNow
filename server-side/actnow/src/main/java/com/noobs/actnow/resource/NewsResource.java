package com.noobs.actnow.resource;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.noobs.actnow.model.dto.News.NewsResponse;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


@RestController
@RequestMapping("/api/news")
public class NewsResource {

    private OkHttpClient client;

    private RestTemplate restTemplate;

    private ObjectMapper mapper;

    @Value("${api.key}")
    String apiKey;

    private final String BASE_URL = "https://api.bing.microsoft.com/v7.0/news";
    private final String MARKETCODE = "?mkt=en-us";
    private final String HEALTHPARAM = "&category=health";
    private final String SCIENCEPARAM = "&category=science";

    @GetMapping(path = "/health", produces =  {MediaType.APPLICATION_JSON_VALUE})
    public NewsResponse getHealthNews() throws IOException {
        
        Request request = new Request.Builder()
                .url(BASE_URL + MARKETCODE + HEALTHPARAM)
                .addHeader("Ocp-Apim-Subscription-Key", apiKey)
                .build();

        NewsResponse resp = null;

        try(Response response = client.newCall(request).execute()) {
            String result = restTemplate.getForObject(BASE_URL + MARKETCODE + HEALTHPARAM, String.class);
            resp = mapper.readValue(result, NewsResponse.class);
            //JSONParser parser = new JSONP
            // json.getString(response.body().string());
            //  objectMapper.registerModule(new ParameterNamesModule());
            // objectMapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
            // objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            // objectMapper.setVisibility(PropertyAccessor.CREATOR, Visibility.ANY);
            //String streamOfNews = objectMapper.writeValueAsString(new News());
            //News[] newsEntity = objectMapper.readValue(response.body().string(), News[].class);
            //return newsEntity.toString();
        } catch (Exception e) {
           throw new IOException(e.getLocalizedMessage());
        }
        return resp;     
    }

    @GetMapping(path = "/science", produces = {MediaType.APPLICATION_JSON_VALUE})
    public NewsResponse getScienceNews() throws IOException {
        Request request = new Request.Builder()
            .url(BASE_URL + MARKETCODE + SCIENCEPARAM)
            .addHeader("Ocp-Apim-Subscription-Key", apiKey)
            .build();
        
        NewsResponse resp = null;

        try(Response response = client.newCall(request).execute()) {
            String result = restTemplate.getForObject(BASE_URL + MARKETCODE + HEALTHPARAM, String.class);
            resp = mapper.readValue(result, NewsResponse.class);
        } catch(Exception e) {
            throw new IOException();
        }

        return resp;
    }
}
