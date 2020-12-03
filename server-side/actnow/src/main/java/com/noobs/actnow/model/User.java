package com.noobs.actnow.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class User {

    @Id
    private Long id;

    private String sessionId;

    private Instant accessedApp;

    private Location location;

}
