/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import java.security.Principal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tien
 */
@CrossOrigin()
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        if (principal != null) { // Kiểm tra đã đăng nhập chưa
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if (auth != null && auth.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                return "redirect:/admin";
            } else {
                return "redirect:/user";
            }
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminHome(Model model) {
        return "adminHome";
    }
        
    @RequestMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userHome(Model model) {
        return "userHome";
    }
}
