/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.repositories.impl;

import com.chungcu.pojo.Apartment;
import com.chungcu.repositories.ApartmentRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
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
public class ApartmentRepositoryImpl implements ApartmentRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Apartment> getApartments(){
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Apartment");
        return q.getResultList();
    };
}
