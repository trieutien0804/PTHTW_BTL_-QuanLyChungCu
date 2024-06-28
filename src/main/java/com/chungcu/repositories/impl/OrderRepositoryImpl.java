/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.repositories.impl;

import com.chungcu.pojo.Locker;
import com.chungcu.pojo.Order1;
import com.chungcu.repositories.OrderRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ptdzu
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class OrderRepositoryImpl implements OrderRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addOrder(Order1 order) {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            session.save(order);
            return true;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean addOrUpdateOrder(Order1 order) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (order.getId() == null) {
                Date date = new Date();
                order.setCreatedAt(date);
                order.setStatus("Chưa nhận hàng");
                session.save(order);
            } else {
                session.update(order);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Order1> getOrderByLockerId(int id) {
        Session session = this.factory.getObject().getCurrentSession(); // Assuming you have a sessionFactory

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Order1> query = builder.createQuery(Order1.class);
            Root<Order1> root = query.from(Order1.class);
            Join<Order1, Locker> lockerJoin = root.join("lockerId", JoinType.INNER); // Inner join to fetch only orders with a locker

            query.select(root)
                 .where(builder.equal(lockerJoin.get("id"), id));

            List<Order1> orders = session.createQuery(query).getResultList();
           

            return orders;

 
    }

    @Override
    public Order1 getOrderById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Order1 order = s.get(Order1.class, id);
        return order;
    }
    
}
