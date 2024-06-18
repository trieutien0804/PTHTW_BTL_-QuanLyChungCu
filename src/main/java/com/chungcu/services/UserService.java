/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.services;

import com.chungcu.pojo.Locker;
import com.chungcu.pojo.Resident;
import com.chungcu.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tien
 */
public interface UserService extends UserDetailsService {

    boolean addUser(User user, Locker locker, Resident resident);

    List<User> getUsers(String username);

    User getLoggedInUser();

    boolean authUser(String username, String password);

    User getUserByUsername(String name);

    boolean checkUniqueUsername(String username);
    
    User getUserById(int id);
    
    boolean updateFirstLogin(User user);
}
