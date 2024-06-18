/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.repositories.impl;

import com.chungcu.pojo.Locker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import com.chungcu.repositories.LockerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tien
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")

public class LockerRepositoryImpl implements LockerRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private Environment env;

    @Override
    public boolean addLocker(Locker locker) {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            session.save(locker);
            return true;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }

    

    @Override
    public List<Locker> getAllLocker(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Locker> q = builder.createQuery(Locker.class);
        Root root = q.from(Locker.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(root.get("type"), String.format("%%%s%%", kw)));
        }

        q.where(predicates.toArray(Predicate[]::new));
        q.orderBy(builder.asc(root.get("id")));

        Query query = session.createQuery(q);

        String p = params.get("page");
        int page = 1;
        if (p != null && !p.isEmpty()) {
            page = Integer.parseInt(p);
        }

        int pagesize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        //int start = ((Integer.parseInt(p) - 1) * pagesize);
        int start = ((page - 1) * pagesize);
        query.setFirstResult(start);
        query.setMaxResults(pagesize);

        List<Locker> locker = query.getResultList();

        return locker;
    }

    @Override
    public int countLocker(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Locker> q = builder.createQuery(Locker.class);
        Root root = q.from(Locker.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(root.get("type"), String.format("%%%s%%", kw)));
        }

        q.where(predicates.toArray(Predicate[]::new));
        q.orderBy(builder.desc(root.get("id")));

        Query query = session.createQuery(q);

        List<Locker> locker = query.getResultList();

        return locker.size();
    }

    @Override
    public boolean addOrUpdateLocker(Locker locker) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (locker.getId() == null) {
                session.save(locker);
            } else {
                session.update(locker);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteLocker(int lockerId) {
        try {
            Session s = this.factory.getObject().getCurrentSession();
            Locker locker = this.getLockerById(lockerId);
            s.delete(locker);
            return true;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
            return false;
        }
    }

    @Override
    public Locker getLockerById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Locker.class, id);
    }

}
