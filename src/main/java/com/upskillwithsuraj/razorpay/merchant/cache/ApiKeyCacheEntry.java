package com.upskillwithsuraj.razorpay.merchant.cache;

import com.upskillwithsuraj.razorpay.comman.enums.Environment;

import java.time.LocalDateTime;
import java.util.UUID;

public record ApiKeyCacheEntry(
        UUID apiKey,
        String keySecretHash,
        String previousKeySecretHas,
        LocalDateTime gracePeriodExpiresAt,
        UUID merchantId,
        Environment environment,
        boolean enabled
) {
}
