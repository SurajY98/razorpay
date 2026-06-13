package com.upskillwithsuraj.razorpay.vault.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "card_token")
public class CardToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(nullable = false, length = 50)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vauly_card_id", nullable = false)
    private VaultCard vaultCard;
    
}
