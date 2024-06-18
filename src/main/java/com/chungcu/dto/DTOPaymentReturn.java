/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author tien
 */
public class DTOPaymentReturn {
    @NotBlank
    private String amount;
    @NotBlank
    private String orderInfor;
    @NotBlank
    private String returnUrl;

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the orderInfor
     */
    public String getOrderInfor() {
        return orderInfor;
    }

    /**
     * @param orderInfor the orderInfor to set
     */
    public void setOrderInfor(String orderInfor) {
        this.orderInfor = orderInfor;
    }

    /**
     * @return the returnUrl
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * @param returnUrl the returnUrl to set
     */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
}
