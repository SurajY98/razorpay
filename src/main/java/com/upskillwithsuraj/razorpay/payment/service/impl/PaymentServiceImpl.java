package com.upskillwithsuraj.razorpay.payment.service.impl;

import com.upskillwithsuraj.razorpay.payment.dto.request.PaymentInitRequest;
import com.upskillwithsuraj.razorpay.payment.dto.response.PaymentResponse;
import com.upskillwithsuraj.razorpay.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentResponse initiate(UUID merchantId, PaymentInitRequest request) {
        return null;
    }
}
