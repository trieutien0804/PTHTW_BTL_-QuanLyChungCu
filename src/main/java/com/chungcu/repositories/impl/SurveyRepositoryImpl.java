/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.repositories.impl;

import com.chungcu.pojo.Survey;
import com.chungcu.repositories.SurveyRepository;
import java.util.List;
import javax.persistence.Query;
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
public class SurveyRepositoryImpl implements SurveyRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Survey> getSurveys() {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Survey");
        return q.getResultList();
    }

    @Override
    public boolean addSurvey(Survey survey) {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            session.save(survey);
            return true;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
            return false;
        }
    }

    @Override
    public Survey getSurveyById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Survey.class, id);
    }

    @Override
    public boolean deleteSurvey(int id) {
        try {
            Session s = this.factory.getObject().getCurrentSession();
            Survey survey = this.getSurveyById(id);
            s.delete(survey);
            return true;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
            return false;
        }
    }

}
