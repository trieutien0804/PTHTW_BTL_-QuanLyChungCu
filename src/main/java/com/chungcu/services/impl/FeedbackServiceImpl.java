/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.services.impl;

import com.chungcu.pojo.Feedback;
import com.chungcu.repositories.FeedbackRepository;
import com.chungcu.services.FeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tien
 */
@Service 
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    private FeedbackRepository feedbackRepo;
    
    @Override
    public List<Feedback> getAllFeedback() {
        return this.feedbackRepo.getAllFeedback();
    }

    @Override
    public boolean addOrUpdateFeedback(Feedback feedback) {
        return this.feedbackRepo.addOrUpdateFeedback(feedback);
    }
    
}
