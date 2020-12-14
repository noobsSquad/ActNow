package com.noobs.actnow.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.noobs.actnow.model.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class SpringUserController {
    
    @PostMapping("/accessUser")
    public String accessUser(User user, HttpServletRequest req) {
        @SuppressWarnings("unchecked")
        List<String> users = (List<String>) req.getSession().getAttribute(user.getId());
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user.getId());
        //req.getSession().setAttribute("active", user.setActive(active););
    }
}
