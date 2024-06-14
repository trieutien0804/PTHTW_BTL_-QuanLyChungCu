/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.pojo.Bill;
import com.chungcu.services.BillService;
import javax.validation.Valid;
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
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("/bill")
    public String billView(Model model) {
        model.addAttribute("bills", billService.getALlBill());
        return "bill";
    }

    @GetMapping("/addBill")
    public String addBillView(Model model) {
        model.addAttribute("bill", new Bill());
        return "addBill";
    }

//    @PostMapping("/addBill")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String addApartment(@ModelAttribute(value = "apartment") @Valid Bill bill, BindingResult result) {
//        if (!result.hasErrors()) {
//            if (apartmentService.addOrUpdateApartment(apartment) == true) {
//                return "redirect:/admin/apartment";
//            }
//        }
//        return "addApartment";
//    }

    @PostMapping("/addBill")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addBill(@ModelAttribute(value = "bill") Bill bill) {
        billService.addOrUpdate(bill);
        return "redirect:/admin/bill";
    }
}
