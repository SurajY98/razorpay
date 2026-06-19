package com.upskillwithsuraj.razorpay.merchant.respository;

import com.upskillwithsuraj.razorpay.merchant.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
    List<ApiKey> findByMerchant_id(UUID merchantId);
}
