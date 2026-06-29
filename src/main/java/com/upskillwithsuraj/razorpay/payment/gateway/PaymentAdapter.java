package com.upskillwithsuraj.razorpay.payment.gateway;

import com.upskillwithsuraj.razorpay.payment.gateway.dto.PaymentRequest;

public interface PaymentAdapter {

    void initiate(PaymentRequest request);
}
