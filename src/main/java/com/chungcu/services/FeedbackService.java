/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungcu.services;

import com.chungcu.pojo.Feedback;
import java.util.List;

/**
 *
 * @author tien
 */
public interface FeedbackService {
    List<Feedback> getAllFeedback();
    boolean addOrUpdateFeedback(Feedback feedback);

}
