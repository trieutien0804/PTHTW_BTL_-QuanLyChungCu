/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.pojo.Bill;
import com.chungcu.services.BillService;
import com.chungcu.services.ResidentService;
import java.util.List;
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
public class BillController {

    @Autowired
    BillService billService;

    @Autowired
    ResidentService residentService;

    @Autowired
    private Environment env;

    @GetMapping("/bill")
    public String billView(Model model, @RequestParam Map<String, String> params) {
        int pagesize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

        List<Bill> bill = billService.getALlBill(params);
        int counter = billService.countBill(params);
        String kw = params.get("kw");
        model.addAttribute("keyword", kw);
        model.addAttribute("counter", Math.ceil((counter) * 1.0 / pagesize));
        model.addAttribute("bills", bill);
        return "bill";
    }

    @GetMapping("/addBill")
    public String addBillView(Model model) {
        model.addAttribute("bill", new Bill());
        return "addBill";
    }

    @PostMapping("/addBill")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addBill(@ModelAttribute(value = "bill") @Valid Bill bill, BindingResult result) {
        if (!result.hasErrors()) {
            if (billService.addOrUpdateBill(bill) == true) {
                return "redirect:/admin/bill";
            }
        }
        return "addBill";
    }

    @GetMapping("/addBill/{id}")
    public String updateBillView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("bill", this.billService.getBillById(id));
        return "addBill";
    }

    @GetMapping("deleteBill/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteBill(@PathVariable(value = "id") int billId, Model model) {
        model.addAttribute("bill", billService.getBillById(billId));
        return "deleteBill";
    }

    @PostMapping("deleteBill")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String submitDeleteBill(@ModelAttribute(value = "bill") Bill bill) {
        if (billService.deleteBill(bill.getId()) == true) {
            return "redirect:/admin/bill";
        }
        return "adminHome";
    }
}
