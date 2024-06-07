/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.formatters;


import com.chungcu.pojo.Survey;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author tien
 */
public class SurveyFormatter implements Formatter<Survey>{

    @Override
    public String print(Survey survey, Locale locale) {
        return String.valueOf(survey.getId());
    }

    @Override
    public Survey parse(String surveyId, Locale locale) throws ParseException {
        int id = Integer.parseInt(surveyId);
        return new Survey(id);
    }
    
}
