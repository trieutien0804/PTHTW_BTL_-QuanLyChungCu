/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.repositories;

import com.chungcu.pojo.Surveyquestion;
import java.util.List;

/**
 *
 * @author tien
 */
public interface SurveyquestionRepository {
    boolean addSurveyQuestion(Surveyquestion question);
    List<Surveyquestion> getAllSurveyQuestionById(int surveyId); 
}
