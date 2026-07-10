package com.upskillwithsuraj.razorpay.payment.controller;

import com.upskillwithsuraj.razorpay.payment.dto.request.PaymentInitRequest;
import com.upskillwithsuraj.razorpay.payment.dto.response.PaymentResponse;
import com.upskillwithsuraj.razorpay.payment.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;
    UUID merchantId = UUID.fromString("e8232702-afc0-46e5-a9c9-58a68693509e");

    @PostMapping
    public ResponseEntity<PaymentResponse> initPayment(@Valid @RequestBody PaymentInitRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.initiate(merchantId, request));
    }
}
