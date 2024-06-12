/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.repositories.impl;

import com.chungcu.pojo.Apartment;
import com.chungcu.pojo.Resident;
import com.chungcu.repositories.ApartmentRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
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
public class ApartmentRepositoryImpl implements ApartmentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Apartment> getApartments() {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Apartment");
        return q.getResultList();
    }

    ;

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
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Apartment> query = cb.createQuery(Apartment.class);
        Root<Apartment> root = query.from(Apartment.class);

        Subquery<Long> subquery = query.subquery(Long.class);
        Root<Resident> subRoot = subquery.from(Resident.class);
        subquery.select(cb.count(subRoot));
        subquery.where(
                cb.equal(subRoot.get("apartmentId"), root.get("id")),
                cb.equal(subRoot.get("isActive"), 1)
        );

        query.select(cb.construct(
                Apartment.class,
                root.get("id"),
                root.get("apartmentNumber"),
                cb.selectCase()
                        .when(cb.greaterThan(subquery, 0L), "Đang cho thuê")
                        .otherwise("Còn trống")
        ));

        return session.createQuery(query).getResultList();
    }

}
