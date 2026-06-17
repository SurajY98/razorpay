package com.upskillwithsuraj.razorpay.merchant.respository;

import com.upskillwithsuraj.razorpay.merchant.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
}
