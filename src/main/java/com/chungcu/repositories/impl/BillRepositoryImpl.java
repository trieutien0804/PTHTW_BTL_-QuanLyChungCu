/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.repositories.impl;


import com.chungcu.pojo.Bill;
import com.chungcu.pojo.Resident;
import com.chungcu.repositories.BillRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class BillRepositoryImpl implements BillRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private Environment env;

    
    @Override
    public List<Bill> getAllBill(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bill> q = builder.createQuery(Bill.class);
        Root root = q.from(Bill.class);
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

        List<Bill> bill = query.getResultList();

        return bill;
    }

    @Override
    public boolean addOrUpdateBill(Bill bill) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (bill.getId() == null) {
                session.save(bill);
            } else {
                session.update(bill);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public Bill getBillById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Bill.class, id);
//        Session session = sessionFactory.getCurrentSession();
//        Bill bill = session.get(Bill.class, id);
//
//        // Không cần thiết phải khởi tạo lại tập hợp cho Bill 
//        // vì nó không có các trường quan hệ một-nhiều như ví dụ Apartment.
//
//        return bill; 
    }

    @Override
    public int countBill(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bill> q = builder.createQuery(Bill.class);
        Root root = q.from(Bill.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(root.get("type"), String.format("%%%s%%", kw)));
        }

        q.where(predicates.toArray(Predicate[]::new));
        q.orderBy(builder.desc(root.get("id")));

        Query query = session.createQuery(q);

        List<Bill> bill = query.getResultList();

        return bill.size();
    }

    @Override
    public boolean deleteBill(int billId) {
        try {
            Session s = this.factory.getObject().getCurrentSession();
            Bill bill = this.getBillById(billId);
            s.delete(bill);
            return true;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
            return false;
        }
    }
    
}
