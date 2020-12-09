package com.noobs.actnow.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

    @Id
    private String id;

    private String address;

    private String city;

    private String state;

    private Integer zipCode;

    private Float latitude;

    private Float longitude;
    
}
