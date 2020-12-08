package com.noobs.actnow.resource;

import java.io.IOException;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.noobs.actnow.model.News;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jdk.nashorn.internal.parser.JSONParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


@RestController
@RequestMapping("/api/news")
public class NewsResource {

    @Autowired
    private OkHttpClient client;

    @Value("${api.key}")
    String apiKey;

    private final String BASE_URL = "https://api.bing.microsoft.com/v7.0/news";
    private final String MARKETCODE = "?mkt=en-us";
    private final String HEALTHPARAM = "&category=health";
    private final String SCIENCEPARAM = "&category=science";

    @GetMapping(path = "/health", produces =  {MediaType.APPLICATION_JSON_VALUE})
    public String getHealthNews() {
        
        Request request = new Request.Builder()
                .url(BASE_URL + MARKETCODE + HEALTHPARAM)
                .addHeader("Ocp-Apim-Subscription-Key", apiKey)
                .build();

        try(Response response = client.newCall(request).execute()) {
            //ObjectMapper objectMapper = new ObjectMapper();
            //JSONParser parser = new JSONP
            // JSONObject json = new JSONObject();
            // json.getString(response.body().string());
            //  objectMapper.registerModule(new ParameterNamesModule());
            // objectMapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
            // objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            // objectMapper.setVisibility(PropertyAccessor.CREATOR, Visibility.ANY);
            //String streamOfNews = objectMapper.writeValueAsString(new News());
            //News[] newsEntity = objectMapper.readValue(response.body().string(), News[].class);
            //return newsEntity.toString();
        } catch (IOException e) {
           return e.getMessage();
        }
    }

    @GetMapping(path = "/science", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getScienceNews() {
        Request request = new Request.Builder()
            .url(BASE_URL + MARKETCODE + SCIENCEPARAM)
            .addHeader("Ocp-Apim-Subscription-Key", apiKey)
            .build();
        
        try(Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch(IOException e) {
            return e.getMessage();
        }
    }
}
