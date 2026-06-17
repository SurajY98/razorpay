package com.upskillwithsuraj.razorpay.merchant.service.impl;

import com.upskillwithsuraj.razorpay.comman.enums.MerchantStatus;
import com.upskillwithsuraj.razorpay.comman.enums.UserRole;
import com.upskillwithsuraj.razorpay.merchant.dto.request.MerchantRequestSignUp;
import com.upskillwithsuraj.razorpay.merchant.dto.response.MerchantResponse;
import com.upskillwithsuraj.razorpay.merchant.entity.AppUser;
import com.upskillwithsuraj.razorpay.merchant.entity.Merchant;
import com.upskillwithsuraj.razorpay.merchant.respository.AppUserRepository;
import com.upskillwithsuraj.razorpay.merchant.respository.MerchantRepository;
import com.upskillwithsuraj.razorpay.merchant.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MerchantRepository merchantRepository;
    private  final AppUserRepository appUserRepository;

    @Override
    @Transactional
    public MerchantResponse signUp(MerchantRequestSignUp request) {
        if(merchantRepository.existByEmail(request.email())){
            throw new RuntimeException("Merchant with email is already present with "+request.email());
        }

        Merchant merchant = Merchant.builder().
                businessName(request.businessName()).
                businessType(request.businessType()).
                name(request.name()).
                email(request.email()).
                status(MerchantStatus.PENDING_KYC).
                build();

        merchant = merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(request.email())
                .passwordHash(request.password())
                .role(UserRole.USER)
                .merchant(merchant)
                .build();

        appUserRepository.save(appUser);
        return new MerchantResponse(merchant.getId(), merchant.getName(), merchant.getName(), merchant.getBusinessName(),
                merchant.getBusinessType(), merchant.getStatus());
    }
}
