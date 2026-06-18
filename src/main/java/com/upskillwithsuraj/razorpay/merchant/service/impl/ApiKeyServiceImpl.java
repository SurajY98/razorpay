package com.upskillwithsuraj.razorpay.merchant.service.impl;

import com.upskillwithsuraj.razorpay.comman.exception.ResourceNotFoundException;
import com.upskillwithsuraj.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.upskillwithsuraj.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.upskillwithsuraj.razorpay.merchant.entity.ApiKey;
import com.upskillwithsuraj.razorpay.merchant.entity.Merchant;
import com.upskillwithsuraj.razorpay.merchant.respository.ApiKeyRepository;
import com.upskillwithsuraj.razorpay.merchant.respository.MerchantRepository;
import com.upskillwithsuraj.razorpay.merchant.service.ApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiKeyServiceImpl implements ApiKeyService {

    private final MerchantRepository merchantRepository;
    private final ApiKeyRepository apiKeyRepository;

    @Override
    public ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant = merchantRepository.findById(merchantId).
                orElseThrow(() -> new ResourceNotFoundException("merchant", merchantId));

        String keyId = "rzp_" + request.environment().name().toLowerCase()+"big_random_secret";
        String rawSecret = "big_random_secret";
        ApiKey apiKey = ApiKey.builder()
                .merchant(merchant)
                .keyId(keyId)
                .keySecretHash(rawSecret)
                .environment(request.environment())
                .build();

        apiKey = apiKeyRepository.save(apiKey);
        return new ApiKeyCreateResponse(apiKey.getId(), keyId, rawSecret, request.environment().name());
    }
}
