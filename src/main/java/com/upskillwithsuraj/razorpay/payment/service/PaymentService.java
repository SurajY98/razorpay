package com.upskillwithsuraj.razorpay.payment.service;

import com.upskillwithsuraj.razorpay.payment.dto.request.PaymentInitRequest;
import com.upskillwithsuraj.razorpay.payment.dto.response.PaymentResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface PaymentService {
    PaymentResponse initiate(UUID merchantId, PaymentInitRequest request);
}
