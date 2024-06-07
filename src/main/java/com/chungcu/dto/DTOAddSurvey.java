/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.dto;

import com.chungcu.pojo.Survey;
import com.chungcu.pojo.Surveyquestion;
import java.util.List;

/**
 *
 * @author tien
 */
public class DTOAddSurvey {

    private Survey survey;
    private List<Surveyquestion> surveyQuestions;

    /**
     * @return the survey
     */
    public Survey getSurvey() {
        return survey;
    }

    /**
     * @param survey the survey to set
     */
    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    /**
     * @return the surveyQuestions
     */
    public List<Surveyquestion> getSurveyQuestions() {
        return surveyQuestions;
    }

    /**
     * @param surveyQuestions the surveyQuestions to set
     */
    public void setSurveyQuestions(List<Surveyquestion> surveyQuestions) {
        this.surveyQuestions = surveyQuestions;
    }
}
