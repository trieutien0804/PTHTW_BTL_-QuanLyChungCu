/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.repositories.impl;

import com.chungcu.pojo.Apartment;
import com.chungcu.pojo.Resident;
import com.chungcu.repositories.ApartmentRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
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
public class ApartmentRepositoryImpl implements ApartmentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;

    @Override
    public List<Apartment> getApartments(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Apartment> q = builder.createQuery(Apartment.class);
        Root root = q.from(Apartment.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(root.get("apartmentNumber"), String.format("%%%s%%", kw)));
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

        List<Apartment> apartments = query.getResultList();

        return apartments;
    }

    @Override
    public boolean addOrUpdateApartment(Apartment apartment) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (apartment.getId() == null) {
                session.save(apartment);
            } else {
                session.update(apartment);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Apartment> findAllApartmentsWithStatus() {

        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Apartment> query = builder.createQuery(Apartment.class);
        Root<Apartment> root = query.from(Apartment.class);

        Subquery<Long> subquery = query.subquery(Long.class);
        Root<Resident> subRoot = subquery.from(Resident.class);
        subquery.select(builder.count(subRoot));
        subquery.where(
                builder.equal(subRoot.get("apartmentId"), root.get("id")),
                builder.equal(subRoot.get("isActive"), 1)
        );

        query.select(builder.construct(
                Apartment.class,
                root.get("id"),
                root.get("apartmentNumber"),
                builder.selectCase()
                        .when(builder.greaterThan(subquery, 0L), "Đang cho thuê")
                        .otherwise("Còn trống")
        ));

        return session.createQuery(query).getResultList();
    }

    @Override
    public Apartment getApartmentById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Apartment apartment = s.get(Apartment.class, id);
        if (apartment != null) {
            apartment.setResidentSet(new HashSet<Resident>(apartment.getResidentSet()));
        }
        return s.get(Apartment.class, id);
    }

    @Override
    public boolean deleteApartment(int apartmentId) {
        try {
            Session s = this.factory.getObject().getCurrentSession();
            Apartment apartment = this.getApartmentById(apartmentId);
            s.delete(apartment);
            return true;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
            return false;
        }
    }

    @Override
    public int countApartment(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Apartment> q = builder.createQuery(Apartment.class);
        Root root = q.from(Apartment.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(root.get("apartmentNumber"), String.format("%%%s%%", kw)));
        }

        q.where(predicates.toArray(Predicate[]::new));
        q.orderBy(builder.desc(root.get("id")));

        Query query = session.createQuery(q);

        List<Apartment> apartments = query.getResultList();

        return apartments.size();
    }

    @Override
    public boolean checkApartmentNumber(String apartmentNumber) {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            String q = "SELECT COUNT(*) FROM Apartment a WHERE a.apartment_number = :apartmentNumber";
            Query query = session.createQuery(q);
            query.setParameter("apartmentNumber", apartmentNumber);
            int count = query.getFirstResult();
            return count > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
