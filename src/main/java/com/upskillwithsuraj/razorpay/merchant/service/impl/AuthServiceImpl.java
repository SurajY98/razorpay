package com.upskillwithsuraj.razorpay.merchant.service.impl;

import com.upskillwithsuraj.razorpay.comman.enums.MerchantStatus;
import com.upskillwithsuraj.razorpay.comman.enums.UserRole;
import com.upskillwithsuraj.razorpay.comman.exception.DuplicateResourceException;
import com.upskillwithsuraj.razorpay.merchant.dto.request.MerchantRequestSignUp;
import com.upskillwithsuraj.razorpay.merchant.dto.response.MerchantResponse;
import com.upskillwithsuraj.razorpay.merchant.entity.AppUser;
import com.upskillwithsuraj.razorpay.merchant.entity.Merchant;
import com.upskillwithsuraj.razorpay.merchant.mapper.MerchantMapper;
import com.upskillwithsuraj.razorpay.merchant.respository.AppUserRepository;
import com.upskillwithsuraj.razorpay.merchant.respository.MerchantRepository;
import com.upskillwithsuraj.razorpay.merchant.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final MerchantRepository merchantRepository;
    private  final AppUserRepository appUserRepository;
    private final MerchantMapper merchantMapper;

    @Override
    @Transactional
    public MerchantResponse signUp(MerchantRequestSignUp request) {
        if(merchantRepository.existsByEmail(request.email())){
            throw new DuplicateResourceException("DUPLICATE_MERCHANT_EMAIL","Merchant with email is already present with "+request.email());
        }

        Merchant merchant = merchantMapper.toEntityFromSignUpRequest(request);
        merchant.setStatus(MerchantStatus.PENDING_KYC);
        merchant = merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(request.email())
                .passwordHash(request.password())
                .role(UserRole.USER)
                .merchant(merchant)
                .build();

        appUserRepository.save(appUser);
        return merchantMapper.toResponse(merchant);
    }
}
