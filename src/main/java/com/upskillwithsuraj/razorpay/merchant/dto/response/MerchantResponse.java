package com.upskillwithsuraj.razorpay.merchant.dto.response;

import com.upskillwithsuraj.razorpay.comman.enums.BusinessType;
import com.upskillwithsuraj.razorpay.comman.enums.MerchantStatus;

import java.util.UUID;

public record MerchantResponse(

        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus

) {
}
