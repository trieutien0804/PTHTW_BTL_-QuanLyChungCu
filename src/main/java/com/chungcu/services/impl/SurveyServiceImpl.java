/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Survey;
import com.chungcu.pojo.Surveyquestion;
import com.chungcu.repositories.SurveyRepository;
import com.chungcu.repositories.SurveyquestionRepository;
import com.chungcu.services.SurveySevice;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tien
 */
@Service
public class SurveyServiceImpl implements SurveySevice {

    @Autowired
    private SurveyRepository surveyRepo;
    
    private SurveyquestionRepository questionRepo;

    @Override
    public List<Survey> getSurveys() {
        return this.surveyRepo.getSurveys();
    }

    @Override
    public boolean addSurvey(Survey survey) {
        survey.setCreatedAt(new Date());
        return this.surveyRepo.addSurvey(survey);
    }
}

//try {
//            int surveyId = this.surveyRepo.addSurvey(survey);
//            if (surveyId != 0) {
//                questions.forEach(question -> {
//                    question.setSurveyId(new Survey(surveyId));
//                    this.questionRepo.addSurveyQuestion(question);
//                });
//                return true;
//            }
//        } catch (HibernateException ex) {
//            System.err.print(ex.getMessage());
//            return false;
//        }
//
//        return false;