package com.upskillwithsuraj.razorpay.merchant.mapper;

import com.upskillwithsuraj.razorpay.merchant.dto.request.MerchantRequestSignUp;
import com.upskillwithsuraj.razorpay.merchant.dto.response.MerchantResponse;
import com.upskillwithsuraj.razorpay.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MerchantMapper {

    Merchant toEntityFromSignUpRequest(MerchantRequestSignUp request);

    MerchantResponse toResponse(Merchant merchant);
}
