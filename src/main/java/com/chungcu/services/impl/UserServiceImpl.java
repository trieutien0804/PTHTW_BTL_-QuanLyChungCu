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
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private Cloudinary cloudinary;

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

    @Override
    public User getUserByUsername(String username) {
        return this.userRepo.getUserByUsername(username);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.userRepo.authUser(username, password);
    }

    @Override
    public boolean checkUniqueUsername(String username) {
        return this.userRepo.checkUniqueUsername(username);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepo.getUserById(id);
    }

    @Override
    public boolean updateFirstLogin(User user) {
        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));
        if (!user.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.userRepo.updateUser(user);
    }

}
