/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Surveyquestion;
import com.chungcu.repositories.SurveyquestionRepository;
import com.chungcu.services.SurveyquestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tien
 */
@Service
public class SurveyquestionServiceImpl implements SurveyquestionService{
    
    @Autowired
    private SurveyquestionRepository questionRepo;
    
    @Override
    public List<Surveyquestion> getAllSurveyQuestionById(int surveyId) {
        return questionRepo.getAllSurveyQuestionById(surveyId);
    }
    
}
