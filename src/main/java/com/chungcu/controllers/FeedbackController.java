/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.pojo.Feedback;
import com.chungcu.services.FeedbackService;
import java.time.LocalDateTime;
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
public class FeedbackController {
    
    @Autowired
    private FeedbackService feedbackService;
    
    @GetMapping("/feedback")
    public String feedbackView(Model model){
        model.addAttribute("feedback", this.feedbackService.getAllFeedback());
        return "feedback";
    }
    @GetMapping("/addFeedback")
    public String addFeedbackView(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "addFeedback";
    }
    @PostMapping("/addFeedback")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addFeedback(@ModelAttribute(value = "feedback") @Valid Feedback feedback, BindingResult result) {
        if (!result.hasErrors()) {
            if (feedbackService.addOrUpdateFeedback(feedback) == true) {
                return "redirect:/admin/bill";
            }
        }
        return "addFeedback";
    }
}
