package com.noobs.actnow.model.dto;

import java.time.Instant;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserDto {

    private String phoneNumber;
    
    private boolean accessApp;

    // private boolean permission;

    //private Instant sessionTime;
}
