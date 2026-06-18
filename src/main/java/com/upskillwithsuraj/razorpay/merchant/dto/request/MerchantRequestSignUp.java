package com.upskillwithsuraj.razorpay.merchant.dto.request;

import com.upskillwithsuraj.razorpay.comman.enums.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MerchantRequestSignUp (

    @NotNull(message = "Name is required")
    @Size(max = 50, message = "Name should not be more then 50 character long")
    String name,

    @Email
    @NotNull(message = "Email is required")
    String email,

    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password should be at leat 8 characters long")
    String password,

    @Size(min = 10, message = "Business name should be at leat 10 characters long")
    String businessName,

    BusinessType businessType
){
}
