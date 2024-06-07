/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.pojo.User;
import com.chungcu.services.ApartmentService;
import com.chungcu.services.UserService;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tien
 */
@CrossOrigin()
@Controller
@ControllerAdvice
public class IndexController {
    
    @Autowired
    private ApartmentService apartmentService;
    
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("apartments", apartmentService.getApartments());
        return "index";
    }  
}
