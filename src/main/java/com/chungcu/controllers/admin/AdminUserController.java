/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers.admin;

import com.chungcu.pojo.User;
import com.chungcu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tien
 */
@Controller
@RequestMapping("/admin/users")
public class AdminUserController {
    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addUserView(Model model) {
        model.addAttribute("user", new User());
        return "adminUser";
    }
    
    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addUser(@ModelAttribute(value = "user") User user) {
        if (this.userDetailsService.addUser(user) == true){
            return "";
        }
        return "";
    }
}
