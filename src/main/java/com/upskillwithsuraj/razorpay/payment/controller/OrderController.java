package com.upskillwithsuraj.razorpay.payment.controller;


import com.upskillwithsuraj.razorpay.payment.dto.request.CreateOrderRequest;
import com.upskillwithsuraj.razorpay.payment.dto.response.CreateOrderResponse;
import com.upskillwithsuraj.razorpay.payment.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    UUID merchantId = UUID.fromString("e8232702-afc0-46e5-a9c9-58a68693509e");

    @PostMapping
    public ResponseEntity<CreateOrderResponse> create(@RequestBody  @Valid CreateOrderRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.create(merchantId, request));
    }

}
