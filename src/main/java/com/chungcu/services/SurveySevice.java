/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.services;

import com.chungcu.pojo.Survey;
import com.chungcu.pojo.Surveyquestion;
import java.util.List;

/**
 *
 * @author tien
 */
public interface SurveySevice {
    List<Survey> getSurveys();
    boolean addSurvey(Survey survey);
}
