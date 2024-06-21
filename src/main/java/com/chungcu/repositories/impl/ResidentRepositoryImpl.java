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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tien
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class ResidentRepositoryImpl implements ResidentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;

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

    @Override
    public List<Object[]> getAllResident(Map<String, String> params) {
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

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(residentRoot.get("name"), String.format("%%%s%%", kw)));
        }

        query.where(predicates.toArray(Predicate[]::new));
        query.orderBy(builder.asc(residentRoot.get("id")));

        Query q = session.createQuery(query);

        String p = params.get("page");
        int page = 1;
        if (p != null && !p.isEmpty()) {
            page = Integer.parseInt(p);
        }

        int pagesize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int start = ((page - 1) * pagesize);
        q.setFirstResult(start);
        q.setMaxResults(pagesize);

        List<Object[]> residents = q.getResultList();

        return residents;
    }

    @Override
    public int countResident(Map<String, String> params) {
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

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(residentRoot.get("name"), String.format("%%%s%%", kw)));
        }

        query.where(predicates.toArray(Predicate[]::new));
        query.orderBy(builder.asc(residentRoot.get("id")));

        Query q = session.createQuery(query);

        List<Object[]> residents = q.getResultList();

        return residents.size();
    }

    @Override
    public Resident getResidentByUserId(int userId) {
        Session session = this.factory.getObject().getCurrentSession();
        String hql = "SELECT r FROM Resident r WHERE r.userId.id = :userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        List<Resident> results = query.getResultList();

        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }

}
