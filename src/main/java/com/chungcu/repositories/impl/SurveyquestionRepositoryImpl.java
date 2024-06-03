/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.repositories.impl;

import com.chungcu.pojo.Surveyquestion;
import com.chungcu.repositories.SurveyquestionRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tien
 */
@Repository
@Transactional
public class SurveyquestionRepositoryImpl implements SurveyquestionRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addSurveyQuestion(Surveyquestion question) {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            session.save(question);
            return true;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }

}
