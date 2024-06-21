/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.configs.PaymentVNPayConfig;
import com.chungcu.dto.DTOPaymentRes;
import com.chungcu.dto.DTOPaymentReturn;
import com.chungcu.pojo.Bill;
import com.chungcu.services.BillService;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tien
 */
@RestController
@RequestMapping("/payment")
public class ApiPaymentController {

    @Autowired
    BillService billService;
    
    @Autowired
    PaymentVNPayConfig paymentVNPayConfig;

    @PostMapping("/create_payment")
    @CrossOrigin
    public ResponseEntity<?> createPayment(@RequestBody Bill bill) throws UnsupportedEncodingException {
//        String orderType = "other";
//        long amount = Integer.parseInt(req.getParameter("amount"))*100;
//        String bankCode = req.getParameter("bankCode");
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        String vnp_TxnRef = PaymentVNPayConfig.getRandomNumber(8);
        String vnp_IpAddr = "192.168.1.136";

        String vnp_TmnCode = PaymentVNPayConfig.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        int intValue = bill.getAmount().intValue() * 100;
        vnp_Params.put("vnp_Amount", String.valueOf(intValue));
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_BankCode", "NCB");

//        if (bankCode != null && !bankCode.isEmpty()) {
//            vnp_Params.put("vnp_BankCode", bankCode);
//        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan ma hoa don:" + bill.getId());
        vnp_Params.put("vnp_OrderType", orderType);
        vnp_Params.put("vnp_Locale", "vn");
//        String locate = req.getParameter("language");
//        if (locate != null && !locate.isEmpty()) {
//            vnp_Params.put("vnp_Locale", locate);
//        } else {
//            vnp_Params.put("vnp_Locale", "vn");
//        }
        vnp_Params.put("vnp_ReturnUrl", PaymentVNPayConfig.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = PaymentVNPayConfig.hmacSHA512(PaymentVNPayConfig.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = PaymentVNPayConfig.vnp_PayUrl + "?" + queryUrl;

        DTOPaymentRes dtoPaymentRes = new DTOPaymentRes();
        dtoPaymentRes.setStatus("Ok");
        dtoPaymentRes.setMessage("Successfully");
        dtoPaymentRes.setURL(paymentUrl);

        return ResponseEntity.status(HttpStatus.OK).body(dtoPaymentRes);
    }

    @GetMapping("/payment_success")
    @CrossOrigin
    public ResponseEntity<?> successPayment(
            @RequestParam(value = "vnp_Amount") String amount,
            @RequestParam(value = "vnp_BankCode") String bankCode,
            @RequestParam(value = "vnp_OrderInfo") String order,
            @RequestParam(value = "vnp_ResponseCode") String responseCode) {
        String billIdStr = order.split(":")[1];
        int billId = Integer.parseInt(billIdStr);
        DTOPaymentReturn dtoPaymentReturn = new DTOPaymentReturn();
        if (responseCode.equals("00")) {
            dtoPaymentReturn.setStatus("Ok");
            dtoPaymentReturn.setMessage("Successfully");
            Bill bill = billService.getBillById(billId);
            bill.setPaymentStatus("Da thanh toan");
            billService.addOrUpdateBill(bill);
            //set lai trang thai cua bill
        } else {
            dtoPaymentReturn.setStatus("No");
            dtoPaymentReturn.setMessage("Failed");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dtoPaymentReturn);
    }

}
