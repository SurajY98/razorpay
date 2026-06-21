package com.upskillwithsuraj.razorpay.payment.service.impl;

import com.upskillwithsuraj.razorpay.comman.exception.DuplicateResourceException;
import com.upskillwithsuraj.razorpay.payment.dto.request.CreateOrderRequest;
import com.upskillwithsuraj.razorpay.payment.dto.response.CreateOrderResponse;
import com.upskillwithsuraj.razorpay.payment.entity.OrderRecord;
import com.upskillwithsuraj.razorpay.payment.respository.OrderRepository;
import com.upskillwithsuraj.razorpay.payment.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Value("${payment.order.default-order-expiry-minutes:30}")
    private int defaultOrderExpiryMinutes;

    @Override
    public CreateOrderResponse create(UUID merchantId, CreateOrderRequest request) {
        if(request.receipt() != null && orderRepository.existsByMerchantIdAndReceipt(merchantId, request.receipt())){
            throw new DuplicateResourceException("ORDER_RECEIPT_DUPLICATE", "Order with receipt already exists" + request.receipt());
        }

        OrderRecord record = OrderRecord.builder()
                .receipt(request.receipt())
                .amount(request.amount())
                .notes(request.notes())
                .merchantId(merchantId)
                .expireAt(request.expireAt() != null ? request.expireAt() : LocalDateTime.now().plusMinutes(defaultOrderExpiryMinutes))
                .build();
        orderRepository.save(record);

        return new CreateOrderResponse(record.getId(), record.getMerchantId(),
                record.getReceipt(),
                record.getAmount(),
                record.getOrderStatus(),
                record.getAttempts(),
                record.getNotes(),
                null,
                record.getExpireAt());
    }


}
