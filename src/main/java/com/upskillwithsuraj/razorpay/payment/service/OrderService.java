package com.upskillwithsuraj.razorpay.payment.service;

import com.upskillwithsuraj.razorpay.payment.dto.request.CreateOrderRequest;
import com.upskillwithsuraj.razorpay.payment.dto.response.CreateOrderResponse;
import com.upskillwithsuraj.razorpay.payment.dto.response.PaymentResponse;

import java.util.UUID;

public interface OrderService {
    CreateOrderResponse create(UUID merchantId, CreateOrderRequest request);

    CreateOrderResponse getById(UUID merchantId, UUID orderId);

    CreateOrderResponse cancel(UUID merchantId, UUID orderId);

    List<PaymentResponse> listPayment(UUID merchantId, UUID orderId);
}
