/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.pojo.Locker;
import com.chungcu.pojo.Order1;
import com.chungcu.pojo.Resident;
import com.chungcu.pojo.User;
import com.chungcu.services.LockerService;
import com.chungcu.services.ResidentService;
import com.chungcu.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class ApiLockerController {

    @Autowired
    ResidentService residentService;

    @Autowired
    UserService userService;
    
    @Autowired
    LockerService lockerService;
    
    @GetMapping("/getOrder")
    @CrossOrigin
    public ResponseEntity<Locker> getOrderUser(@RequestParam(value = "userId") int userId) {
        User u = this.userService.getUserById(userId);
        Resident resident = this.residentService.getResidentByUserId(u.getId());
        Locker locker = this.lockerService.getLockerByResidentId(resident.getId());
       
        return new ResponseEntity<>(locker, HttpStatus.OK);
    }
}
