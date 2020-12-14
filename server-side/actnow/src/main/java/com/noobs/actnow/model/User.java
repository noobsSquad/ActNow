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

    private boolean active;

    // private enum Permission {
    //     ALWAYS_ALLOW("ALWAYS_ALLOW"),
    //     ONLY_ALLOW_WHILE_USING_APP("ONLY_ALLOW_WHILE_USING_APP"),
    //     DONT_ALLOW("DONT_ALLOW");
    
    //     private final String permission;
    
    //     private Permission(String permission) {
    //         this.permission = permission;
    //     }
    // }

}
