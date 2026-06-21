package com.upskillwithsuraj.razorpay.payment.service;

import com.upskillwithsuraj.razorpay.payment.dto.request.CreateOrderRequest;
import com.upskillwithsuraj.razorpay.payment.dto.response.CreateOrderResponse;

import java.util.UUID;

public interface OrderService {
    CreateOrderResponse create(UUID merchantId, CreateOrderRequest request);
}
