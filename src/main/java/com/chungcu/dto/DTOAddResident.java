/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.dto;

import com.chungcu.pojo.Locker;
import com.chungcu.pojo.Resident;
import com.chungcu.pojo.User;

/**
 *
 * @author tien
 */
public class DTOAddResident {

    private User user;
    private Resident resident;
    private Locker locker;

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the resident
     */
    public Resident getResident() {
        return resident;
    }

    /**
     * @param resident the resident to set
     */
    public void setResident(Resident resident) {
        this.resident = resident;
    }

    /**
     * @return the locker
     */
    public Locker getLocker() {
        return locker;
    }

    /**
     * @param locker the locker to set
     */
    public void setLocker(Locker locker) {
        this.locker = locker;
    }

}
