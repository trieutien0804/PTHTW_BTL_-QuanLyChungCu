/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.dto;

import com.chungcu.pojo.Bill;
import java.util.List;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author tien
 */
public class DTOPaymentReturn {
    private String Status;
    private String Message;
    private List<Bill> Data;

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the Message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * @param Message the Message to set
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }

    /**
     * @return the Data
     */
    public List<Bill> getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(List<Bill> Data) {
        this.Data = Data;
    }

    /**
     * @param Data the Data to set
     */

}
