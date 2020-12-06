package com.noobs.actnow.model;

import java.time.Instant;

import com.mongodb.lang.NonNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document
public class User {

    @Id
    private String id;

    @Indexed
    @NonNull
    private String phoneNumber;

    private String sessionId;

    private boolean accessedApp;

    // private boolean permission;

    // private Location location;

    private Instant sessionTime;

}
