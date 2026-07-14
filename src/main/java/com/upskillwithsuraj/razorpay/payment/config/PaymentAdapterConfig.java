package com.upskillwithsuraj.razorpay.payment.config;

import com.upskillwithsuraj.razorpay.comman.enums.PaymentMethod;
import com.upskillwithsuraj.razorpay.payment.gateway.PaymentAdapter;
import com.upskillwithsuraj.razorpay.payment.gateway.adapter.CardPaymentAdapter;
import com.upskillwithsuraj.razorpay.payment.gateway.adapter.NetBankingPaymentAdapter;
import com.upskillwithsuraj.razorpay.payment.gateway.adapter.UpiPaymentAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PaymentAdapterConfig  {

    @Bean
    public Map<PaymentMethod, PaymentAdapter> paymentAdapterMap() {
        return Map.of(
                PaymentMethod.CARD, new CardPaymentAdapter(),
                PaymentMethod.NETBANKING,new NetBankingPaymentAdapter(),
                PaymentMethod.UPI, new UpiPaymentAdapter()
        );
    }
}
