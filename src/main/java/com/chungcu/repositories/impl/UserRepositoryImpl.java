/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.repositories.impl;

import com.chungcu.pojo.Resident;
import com.chungcu.pojo.User;
import com.chungcu.repositories.UserRepositories;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tien
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepositories {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public int addUser(User user) {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            int id = (Integer) session.save(user);
            return id;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
            return 0;
        }
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        if (!username.isEmpty()) {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            Session s = this.factory.getObject().getCurrentSession();
            Query q = s.createQuery("FROM User WHERE username = :username");
            q.setParameter("username", username);
            User u = (User) q.getSingleResult();
            Resident resident = u.getResident();
            if (u != null) {
                u.setResident(resident);
        }
            return (User) q.getSingleResult();
        } catch (HibernateException e) {
            System.err.print(e.getMessage());
        }
        return null;

    }

    @Override
    public boolean authUser(String username, String password) {
        User u = this.getUserByUsername(username);
        return this.passEncoder.matches(password, u.getPassword());
    }

//    @Override
//    public User getUserById(int userId) {
//        Session session = this.factory.getObject().getCurrentSession();
//        User user = session.get(User.class, userId);
//        return user;
//    }
    @Override
    public boolean checkUniqueUsername(String username) {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            String q = "SELECT COUNT(*) FROM User u WHERE u.username = :userName";
            Query query = session.createQuery(q);
            query.setParameter("userName", username);
            int count = query.getFirstResult();
            return count > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        User user = s.get(User.class, id);
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        Session session = this.factory.getObject().getCurrentSession();
        Short isNotFirstLogin = 0;
        user.setIsFirstLogin(isNotFirstLogin);
        try {
            session.update(user);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        try {
            Session s = this.factory.getObject().getCurrentSession();
            User user = this.getUserById(userId);
            s.delete(user);
            return true;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
            return false;
        }
    }
}
