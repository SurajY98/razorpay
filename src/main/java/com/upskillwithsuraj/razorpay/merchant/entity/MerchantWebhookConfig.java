package com.upskillwithsuraj.razorpay.merchant.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.processing.Find;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config", indexes = {
        @Index(name = "idx_webhook_merchant_id", columnList = "merchant_id, enabled")
})
public class MerchantWebhookConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(nullable = false, length = 500)
    private String targetUrl;

    @Column(length = 255)
    private String webHookSecretHash;

    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(length = 255)
    private String eventType;

}
