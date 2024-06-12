/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.dto.DTOAddResident;
import com.chungcu.pojo.Locker;
import com.chungcu.pojo.Resident;
import com.chungcu.pojo.User;
import com.chungcu.services.ApartmentService;
import com.chungcu.services.ResidentService;
import com.chungcu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tien
 */
@Controller
@RequestMapping("/admin")
public class ResidentController {

    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private UserService userService;
    @Autowired
    private ResidentService residentService;

    @GetMapping("/resident")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String residentView(Model model) {
        model.addAttribute("residentDetails", this.residentService.getAllResident());
        return "resident";
    }

    @GetMapping("/addResident")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addResidentView(Model model) {
        
        DTOAddResident addResident = new DTOAddResident();
        addResident.setUser(new User());
        addResident.setResident(new Resident());
        addResident.setLocker(new Locker());
        
        model.addAttribute("availableApartments", apartmentService.findAvailableApartments());
        model.addAttribute("addResident", addResident);
        return "addResident";
    }

    @PostMapping("/addResident")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addResident(@ModelAttribute("addResidentForm") DTOAddResident addResident, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addResident";
        }
        User user = addResident.getUser();
        Resident resident = addResident.getResident();
        Locker locker = addResident.getLocker();
        if (userService.addUser(user, locker, resident))
            return "redirect:/admin/resident";
        return "addResident";
    }
}
