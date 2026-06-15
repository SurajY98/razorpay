package com.upskillwithsuraj.razorpay.operations.entity;

import jakarta.persistence.Embeddable;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;

import java.util.UUID;

@Embeddable
public class SettlementPaymentId {

    private UUID settlementId;

    private UUID paymentId;
}
