/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.pojo.Apartment;
import com.chungcu.services.ApartmentService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tien
 */
@Controller
@RequestMapping("/admin")
@PropertySource("classpath:configs.properties")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private Environment env;

    @GetMapping("/apartment")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createView(Model model, @RequestParam Map<String, String> params) {
        int pagesize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        List<Apartment> apartments = apartmentService.getApartments(params);
        int counter = apartmentService.countApartment(params);
        String kw = params.get("kw");
        model.addAttribute("keyword", kw);
        model.addAttribute("counter", Math.ceil((counter) * 1.0 / pagesize));
        model.addAttribute("apartments", apartments);
        return "apartment";
    }

    @GetMapping("/addApartment")
    public String addApartmentView(Model model) {
        model.addAttribute("apartment", new Apartment());
        return "addApartment";
    }

    @PostMapping("/addApartment")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addApartment(@ModelAttribute(value = "apartment") @Valid Apartment apartment, BindingResult result) {
        if (!result.hasErrors()) {
            if (apartmentService.addOrUpdateApartment(apartment) == true) {
                return "redirect:/admin/apartment";
            }
        }
        return "addApartment";
    }

    @GetMapping("/addApartment/{id}")
    public String updateView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("apartment", this.apartmentService.getApartmentById(id));
        return "addApartment";
    }

    @GetMapping("deleteApartment/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteApartment(@PathVariable(value = "id") int apartmentId, Model model) {
        model.addAttribute("apartment", apartmentService.getApartmentById(apartmentId));
        return "deleteApartment";
    }

    @PostMapping("deleteApartment")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String submitDeleteApartment(@ModelAttribute(value = "apartment") Apartment apartment) {
        if (apartmentService.deleteApartment(apartment.getId()) == true) {
            return "redirect:/admin/apartment";
        }
        return "adminHome";
    }
}
