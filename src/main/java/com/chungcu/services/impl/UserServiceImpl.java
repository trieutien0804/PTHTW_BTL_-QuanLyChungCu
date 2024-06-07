/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Locker;
import com.chungcu.pojo.Resident;
import com.chungcu.pojo.User;
import com.chungcu.repositories.LockerRepository;
import com.chungcu.repositories.ResidentRepository;
import com.chungcu.repositories.UserRepositories;
import com.chungcu.services.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tien
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositories userRepo;

    @Autowired
    private ResidentRepository residentRepo;

    @Autowired
    private LockerRepository lockerRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public boolean addUser(User user, Locker locker, Resident resident) {
        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));
        user.setRole(User.USER);
        try {
            int userId = this.userRepo.addUser(user);
            if (userId != 0) {
                resident.setUserId(new User(userId));
                short active = 1;
                resident.setIsActive(active);
                int residentId = this.residentRepo.addResident(resident);
                if (residentId != 0) {
                    locker.setResidentId(new Resident(residentId));
                    this.lockerRepo.addLocker(locker);
                    return true;
                }
            }
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());  
            return false;
        }

        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        return this.userRepo.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Nguoi dung khong ton tai");
        }
        User user = users.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }

    @Override
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            List<User> users = userRepo.getUsers(username);
            if (users != null && !users.isEmpty()) {
                return users.get(0);
            }
        }
        return null;
    }
//    @Override
//    public boolean authUser(String username, String password) {
//        return this.userRepo.authUser(username, password);
//    }
//    @Override
//    public User getUserByUsername(String username) {
//        return this.userRepo.getUserByUsername(username);
//    }

    @Override
    public boolean authUser(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getUserByUsername(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
