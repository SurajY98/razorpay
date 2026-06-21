package com.upskillwithsuraj.razorpay.payment.dto.response;

import com.upskillwithsuraj.razorpay.comman.entity.Money;
import com.upskillwithsuraj.razorpay.comman.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record CreateOrderResponse(
        UUID id,
        UUID merchantId,
        String receipt,
        Money money,
        OrderStatus status,
        Integer attempts,
        Map<String, Object> notes,
        LocalDateTime createdAt,
        LocalDateTime expireAt

) {
}
