/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.repositories;

import com.chungcu.pojo.User;
import java.util.List;

/**
 *
 * @author tien
 */
public interface UserRepositories {
    int addUser(User user);
    List<User> getUsers(String username);
//    User getUserById(int userId);
}
