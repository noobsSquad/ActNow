package com.noobs.actnow.model;

import org.springframework.data.annotation.Id;

public class Location {

    @Id
    private Long id;

    private String address;

    private String city;

    private String state;

    private Integer zipCode;

    private Float latitude;

    private Float longitude;
}
