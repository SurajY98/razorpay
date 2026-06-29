package com.upskillwithsuraj.razorpay.payment.gateway.dto;

import com.upskillwithsuraj.razorpay.comman.entity.Money;

import java.util.Map;
import java.util.UUID;

public record PaymentRequest(
        UUID paymentId,
        UUID merchantId,
        UUID orderId,
        Money amount,
        Map<String, Object> methodDetails
) {
}
