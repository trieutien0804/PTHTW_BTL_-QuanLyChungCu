    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Survey;
import com.chungcu.repositories.SurveyRepository;
import com.chungcu.repositories.SurveyquestionRepository;
import com.chungcu.services.SurveySevice;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tien
 */
@Service
public class SurveyServiceImpl implements SurveySevice {

    @Autowired
    private SurveyRepository surveyRepo;

    @Override
    public List<Survey> getSurveys() {
        return this.surveyRepo.getSurveys();
    }

    @Override
    public boolean addSurvey(Survey survey) {
        survey.setCreatedAt(new Date());
        return this.surveyRepo.addSurvey(survey);
    }

    @Override
    public boolean deleteSurvey(int id) {
        return this.surveyRepo.deleteSurvey(id);
    }

    @Override
    public Survey getSurveyById(int id) {
        return this.surveyRepo.getSurveyById(id);
    }
}