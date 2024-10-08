/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.dto.DTOPaymentReturn;
import com.chungcu.pojo.Apartment;
import com.chungcu.pojo.Bill;
import com.chungcu.pojo.Resident;
import com.chungcu.pojo.User;
import com.chungcu.services.ApartmentService;
import com.chungcu.services.BillService;
import com.chungcu.services.ResidentService;
import com.chungcu.services.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tien
 */
@RestController
@RequestMapping("/api")
public class ApiBillController {

    @Autowired
    ResidentService residentService;

    //lay resident va so ra tat ca cac bill cua resident 
    @Autowired
    BillService billService;

    @Autowired
    UserService userService;

    @GetMapping("/getbill")
    @CrossOrigin
    public ResponseEntity<List<Bill>> getBill(@RequestParam int userId) {
        return new ResponseEntity<>(this.billService.getBills(), HttpStatus.OK);
    }

    @GetMapping(path = "/current-resident/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<?> getCurrentUser(
            @RequestParam("id") int userId) {

        User u = this.userService.getUserById(userId);
        Resident resident = this.residentService.getResidentByUserId(u.getId());
        List<Bill> bills = billService.getBillsOfResident(resident.getId());
       
            return new ResponseEntity<>(bills, HttpStatus.OK);
    }
}
