package com.upskillwithsuraj.razorpay.operations.entity;

import com.upskillwithsuraj.razorpay.comman.entity.BaseEntity;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class SettlementPaymentId {

    private UUID settlementId;

    private UUID paymentId;
}
