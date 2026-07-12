package com.upskillwithsuraj.razorpay.payment.gateway;

import com.upskillwithsuraj.razorpay.payment.gateway.dto.PaymentRequest;

public interface PaymentAdapter {
    public void initiate(PaymentRequest request);
}
