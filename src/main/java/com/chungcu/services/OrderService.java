/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.services;


import com.chungcu.pojo.Order1;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tien
 */
public interface OrderService {
    boolean addOrder(Order1 order);
    boolean addOrUpdateOrder(Order1 order);
    List<Order1> getOrderByLockerId(int id);

}
