package com.upskillwithsuraj.razorpay.payment.gateway;

import com.upskillwithsuraj.razorpay.payment.gateway.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentGatewayRouter {

    private final Map<String, PaymentAdapter> paymentAdapters;

    public void initiate(PaymentRequest request){
        PaymentAdapter adapter = paymentAdapters.get(request.method());
        if (adapter == null){
            throw new IllegalArgumentException("No Payment registered for this methods" + request.method());
        }

        adapter.initiate(request);

    }
}
