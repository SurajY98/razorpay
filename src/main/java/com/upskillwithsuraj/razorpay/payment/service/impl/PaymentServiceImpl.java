package com.upskillwithsuraj.razorpay.payment.service.impl;

import com.upskillwithsuraj.razorpay.comman.enums.OrderStatus;
import com.upskillwithsuraj.razorpay.comman.enums.PaymentStatus;
import com.upskillwithsuraj.razorpay.comman.exception.BusinessRuleViolationException;
import com.upskillwithsuraj.razorpay.comman.exception.ResourceNotFoundException;
import com.upskillwithsuraj.razorpay.payment.dto.request.PaymentInitRequest;
import com.upskillwithsuraj.razorpay.payment.dto.response.PaymentResponse;
import com.upskillwithsuraj.razorpay.payment.entity.OrderRecord;
import com.upskillwithsuraj.razorpay.payment.entity.Payment;
import com.upskillwithsuraj.razorpay.payment.gateway.PaymentGatewayRouter;
import com.upskillwithsuraj.razorpay.payment.gateway.dto.PaymentRequest;
import com.upskillwithsuraj.razorpay.payment.respository.OrderRepository;
import com.upskillwithsuraj.razorpay.payment.respository.PaymentRepository;
import com.upskillwithsuraj.razorpay.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentGatewayRouter paymentGatewayRouter;

    @Override
    public PaymentResponse initiate(UUID merchantId, PaymentInitRequest request) {

        OrderRecord order = orderRepository.findByIdAndMerchantId(request.orderId(), merchantId).
                orElseThrow(() -> new ResourceNotFoundException("Order", request.orderId()));

        if(order.getOrderStatus() != OrderStatus.CREATED && order.getOrderStatus() != OrderStatus.ATTEMPTED){
            throw new BusinessRuleViolationException("ORDER_NOT_PAYABLE_STATE",
                    "Order can't accept payment in status "+ order.getOrderStatus());
        }

        order.setOrderStatus(OrderStatus.ATTEMPTED);
        order.setAttempts(order.getAttempts() + 1);

        Payment payment = Payment.builder()
                .order(order)
                .merchantId(merchantId)
                .amount(order.getAmount())
                .paymentStatus(PaymentStatus.CREATED)
                .method(request.method())
                .methodDetails(request.methodDetails())
                .build();

        payment =  paymentRepository.save(payment);

        PaymentRequest paymentRequest = new PaymentRequest(payment.getId(),
                merchantId, request.orderId(),
                order.getAmount(),request.method(),
                request.methodDetails());

        paymentGatewayRouter.initiate(paymentRequest);
        return null;
    }
}
