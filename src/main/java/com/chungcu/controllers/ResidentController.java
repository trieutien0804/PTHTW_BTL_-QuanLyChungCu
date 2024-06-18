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
import com.chungcu.services.LockerService;
import com.chungcu.services.ResidentService;
import com.chungcu.services.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ResidentController {

    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private UserService userService;
    @Autowired
    private ResidentService residentService;
    @Autowired
    private LockerService lockerService;
    @Autowired
    private Environment env;

    @GetMapping("/resident")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String residentView(Model model, @RequestParam Map<String, String> params) {
        int pagesize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int counter = residentService.countResident(params);
        String kw = params.get("kw");
        model.addAttribute("keyword", kw);
        model.addAttribute("counter", Math.ceil((counter) * 1.0 / pagesize));
        model.addAttribute("residentDetails", this.residentService.getAllResident(params));
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
    public String addResident(@ModelAttribute("addResidentForm") @Valid DTOAddResident addResident, BindingResult result) {
        if (result.hasErrors()) {
            return "addResident";
        }
        User user = addResident.getUser();
        Resident resident = addResident.getResident();
        Locker locker = addResident.getLocker();
        if (userService.addUser(user, locker, resident)) {
            return "redirect:/admin/resident";
        }
        return "addResident";
    }

//    @GetMapping("deleteResident/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String deleteSurvey(@PathVariable(value = "id") int residentId, Model model) {
//        DTOAddResident addResident = new DTOAddResident();
//        addResident.setUser(userService.getUserByResidentId(residentId));
//        addResident.setResident(residentService.getResidentById(residentId));
//        addResident.setLocker(lockerService.getLockerByResidentId(residentId));
//        model.addAttribute("deleteResident", addResident);
//        return "deleteResident";
//    }

//    @PostMapping("deleteApartment")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String submitDeleteSurvey(@ModelAttribute(value = "apartment") Apartment apartment) {
//        if (apartmentService.deleteApartment(apartment.getId()) == true) {
//            return "redirect:/admin/apartment";
//        }
//        return "adminHome";
//    }
}
