/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.dto.DTOAddSurvey;
import com.chungcu.pojo.Survey;
import com.chungcu.pojo.Surveyquestion;
import com.chungcu.services.SurveySevice;
import com.chungcu.services.SurveyquestionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tien
 */
@Controller
@RequestMapping("/admin")
public class SurveyController {

    @Autowired
    private SurveySevice surveyService;

    @Autowired
    private SurveyquestionService questionService;
    
    @GetMapping("/survey")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String surveyView(Model model) {
        model.addAttribute("surveys", surveyService.getSurveys());
        model.addAttribute("newSurvey", new Survey());
        return "survey";
    }

    @PostMapping("/addSurvey")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addSurvey(@ModelAttribute(value = "newSurvey") Survey survey) {
        if (surveyService.addSurvey(survey) == true) {
            return "redirect:/admin/survey";
        }
        return "adminHome";
    }

    @GetMapping("deleteSurvey/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteSurvey(@PathVariable(value = "id") int surveyId, Model model) {
        model.addAttribute("survey", surveyService.getSurveyById(surveyId));
        return "deleteSurvey";
    }

    @PostMapping("deleteSurvey")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String submitDeleteSurvey(@ModelAttribute(value = "survey") Survey survey) {
        if (surveyService.deleteSurvey(survey.getId()) == true) {
            return "redirect:/admin/survey";    
        }
        return "adminHome";
    }
    
    @GetMapping("surveyQuestion/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String surveyQuestionView(@PathVariable(value = "id") int surveyId, Model model) {
        model.addAttribute("questions", questionService.getAllSurveyQuestionById(surveyId));
        return "surveyQuestion";
    }
    @GetMapping("/add/{id}")
    public String updateSurveyView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("bill", this.surveyService.getSurveyById(id));
        return "addBill";
    }
}
