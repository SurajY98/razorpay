package com.upskillwithsuraj.razorpay.payment.gateway;

import com.upskillwithsuraj.razorpay.payment.gateway.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentGatewayRouter {

    public void initiate(PaymentRequest request){

    }
}
