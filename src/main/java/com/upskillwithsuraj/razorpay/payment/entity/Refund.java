package com.upskillwithsuraj.razorpay.payment.entity;

import com.upskillwithsuraj.razorpay.comman.entity.Money;
import com.upskillwithsuraj.razorpay.comman.enums.RefundStatus;
import com.upskillwithsuraj.razorpay.merchant.entity.Merchant;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "refund")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Payment payment;

    private UUID merchant_id;

    private Money amount;

    private RefundStatus status = RefundStatus.PENDING;

    private String bankReference;

    private String errorCode;

    private String errorDescription;




}
