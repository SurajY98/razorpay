package com.upskillwithsuraj.razorpay.payment.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.upskillwithsuraj.razorpay.comman.entity.Money;
import com.upskillwithsuraj.razorpay.comman.enums.PaymentMethod;
import com.upskillwithsuraj.razorpay.comman.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public record PaymentResponse(
        UUID id,
        UUID orderRecordId,
        UUID merchantId,
        Money amount,
        PaymentStatus status,
        PaymentMethod method,
        Map<String, Object> methodDetails,
        String errorCode,
        String errorDescription,
        LocalDateTime capturedAt,
        LocalDateTime createdAt

) {
}
