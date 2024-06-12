/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.repositories.impl;

import com.chungcu.pojo.Apartment;
import com.chungcu.pojo.Locker;
import com.chungcu.pojo.Resident;
import com.chungcu.pojo.User;
import com.chungcu.repositories.ResidentRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
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
public class ResidentRepositoryImpl implements ResidentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public int addResident(Resident resident) {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            int id = (Integer) session.save(resident);
            return id;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
            return 0;
        }
    }

//    @Override
//    public List<Resident> getAllResident() {
//        Session session = this.factory.getObject().getCurrentSession();
//        Query q = session.createQuery("FROM Resident");
//        return q.getResultList();
//    }
    @Override
    public List<Object[]> getAllResident() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root<Resident> residentRoot = query.from(Resident.class);

        Join<Resident, User> userJoin = residentRoot.join("userId");

        Join<Resident, Apartment> apartmentJoin = residentRoot.join("apartmentId");

        Join<Resident, Locker> lockerJoin = residentRoot.join("lockerSet", JoinType.LEFT);

        query.multiselect(
                residentRoot.get("id").alias("residentId"),
                residentRoot.get("name").alias("name"),
                userJoin.get("username").alias("username"),
                residentRoot.get("phoneNumber").alias("phoneNumber"),
                residentRoot.get("email").alias("email"),
                apartmentJoin.get("apartmentNumber").alias("apartmentNumber"),
                lockerJoin.get("lockerNumber").alias("lockerNumber")
        );
        return session.createQuery(query).getResultList();
    }
    
}
