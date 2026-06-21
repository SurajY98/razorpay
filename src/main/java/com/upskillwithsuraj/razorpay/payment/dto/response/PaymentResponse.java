package com.upskillwithsuraj.razorpay.payment.dto.response;

import com.upskillwithsuraj.razorpay.comman.enums.PaymentMethod;
import com.upskillwithsuraj.razorpay.comman.enums.PaymentStatus;

@JsonInclude(JsonInclude.Include,NON_NULL)
public record PaymentResponse(
        UUID id,
        UUID orderId,
        UUID merchantId,
        MoneyDto amount,
        PaymentStatus status,
        PaymentMethod method,
        Map<String, Object> methodDetails,
        String cardLastFour,
        String CardBrand,
        String bankReference,
        String errorCode,
        String errorDescription,
        Long refundedAmountPaise,
        LocalDateTime capturedAt,
        LocalDateTime createdAt

) {
}
