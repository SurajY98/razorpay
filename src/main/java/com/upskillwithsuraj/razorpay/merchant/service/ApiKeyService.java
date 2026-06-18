package com.upskillwithsuraj.razorpay.merchant.service;

import com.upskillwithsuraj.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.upskillwithsuraj.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface ApiKeyService {
    ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request);
}
