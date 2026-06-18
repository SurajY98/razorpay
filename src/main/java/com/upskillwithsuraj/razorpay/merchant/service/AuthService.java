package com.upskillwithsuraj.razorpay.merchant.service;

import com.upskillwithsuraj.razorpay.merchant.dto.request.MerchantRequestSignUp;
import com.upskillwithsuraj.razorpay.merchant.dto.response.MerchantResponse;
import org.springframework.stereotype.Service;

public interface AuthService {
    public MerchantResponse signUp(MerchantRequestSignUp request);

}
