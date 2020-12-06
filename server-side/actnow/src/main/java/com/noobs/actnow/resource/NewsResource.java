package com.noobs.actnow.resource;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
          return response.body().string();
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
