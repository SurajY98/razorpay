package com.upskillwithsuraj.razorpay.merchant.service;

import com.upskillwithsuraj.razorpay.merchant.dto.request.MerchantRequestSignUp;
import com.upskillwithsuraj.razorpay.merchant.dto.response.MerchantResponse;

public interface AuthService {
    public MerchantResponse signUp(MerchantRequestSignUp request);

}
