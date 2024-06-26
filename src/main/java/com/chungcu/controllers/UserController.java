/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.pojo.User;
import com.chungcu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tien
 */
@Controller
public class UserController {

    @Autowired

    private UserService userDetailsService; 


    @RequestMapping("/loginsuccess")
    public String loginSuccess() {
        User user = userDetailsService.getLoggedInUser();
        if ("ROLE_ADMIN".equals(user.getRole())) {
            return "redirect:/admin";
        }
        else if ("ROLE_USER".equals(user.getRole())){
            return "redirect:/user";
        }
        return "/";
    }
}
