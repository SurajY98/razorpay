package com.upskillwithsuraj.razorpay.merchant.controller;

import com.upskillwithsuraj.razorpay.merchant.dto.request.MerchantRequestSignUp;
import com.upskillwithsuraj.razorpay.merchant.dto.response.MerchantResponse;
import com.upskillwithsuraj.razorpay.merchant.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MerchantResponse> signUp(@RequestBody @Valid MerchantRequestSignUp request){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                authService.signUp(request)
        );
    }
}
