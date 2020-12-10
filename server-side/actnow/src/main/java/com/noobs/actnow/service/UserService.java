package com.noobs.actnow.service;

import java.time.Instant;
import java.util.UUID;

import com.noobs.actnow.model.User;
import com.noobs.actnow.model.dto.UserDto;
import com.noobs.actnow.repository.UserRepository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "User")
public class UserService {

    private final UserRepository userRepository;
    
    private final MongoTemplate mongoTemplate;

    //user enters the app 
    public void userAccess(UserDto user) {
        User newUser = new User();
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setSessionId(UUID.randomUUID().toString());
        newUser.setAccessedApp(user.isAccessApp());
        newUser.setSessionTime(Instant.now());
        this.userRepository.save(newUser);
    }
    
    //user exits the app 
        //check if user has entered the app < email , user >  
    @CachePut(value = "user", key = "#phoneNumber")
    public User logoutUserByEmail(String phoneNumber, boolean accessedApp) {
        final Query query = new Query(Criteria.where("phoneNumber").is(phoneNumber).and("accessedApp").is(true));
        final Update update = new Update().set("accessedApp", false);
        return this.mongoTemplate.findAndModify(query, update, User.class);
    }
    
    //user doesn't go on app for while
        //delete by email
    @CachePut(key = "#phoneNumber", value = "user", unless = "#result == user")
    public User generateSessionId(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user.getSessionTime() != Instant.now().plusSeconds(1000000L)) {
            final Query query = new Query(Criteria.where("phoneNumber").is(phoneNumber));
            final Update update = new Update().set("sessionId", UUID.randomUUID().toString());
            return this.mongoTemplate.findAndModify(query, update, User.class);
        }
        return user;
    }
    
    //find user by their sessionId
    @Cacheable(value = "user", key = "#phoneNumber", unless = "#result == null")
    public User getUserBySessionId(String phoneNumber) {
       return this.userRepository.findByPhoneNumber(phoneNumber);
    }
}
