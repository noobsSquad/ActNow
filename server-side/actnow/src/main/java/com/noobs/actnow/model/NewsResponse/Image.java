package com.noobs.actnow.model.NewsResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {
    private String contentUrl;
    private Integer width;
    private Integer height;
}
