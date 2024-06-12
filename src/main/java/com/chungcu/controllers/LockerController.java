/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.pojo.Locker;
import com.chungcu.services.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tien
 */
@Controller
@RequestMapping("/admin")
public class LockerController {
    
    @Autowired
    private LockerService lockerService;
    
    @GetMapping("/locker")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String lockerView(Model model) {
        model.addAttribute("locker", lockerService.getAllLocker());
        return "locker";
    }
}
