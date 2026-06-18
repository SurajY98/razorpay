package com.upskillwithsuraj.razorpay.merchant.dto.request;

import com.upskillwithsuraj.razorpay.comman.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
