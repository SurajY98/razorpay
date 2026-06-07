package com.upskillwithsuraj.razorpay.comman.entity;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class Money {
    private int amountUnit;
    private String currency;

    private Money(int amountUnit, String currency) {
        this.amountUnit = amountUnit;
        this.currency = currency;
    }

    public static Money of(int amountUnit, String currency){
        return new Money(amountUnit,currency);
    }

    private static Money inr(int amountUnit){
        return new Money(amountUnit,"INR");
    }

    public Money add(Money other){
        if (!this.currency.equals(other.currency)){
            throw new IllegalArgumentException("Can not add money with different currencies");
        }
        return new Money(this.amountUnit + other.amountUnit, this.currency);
    }

    public Money subtract(Money other){
        if (!this.currency.equals(other.currency)){
            throw new IllegalArgumentException("Can not subtract money with different currencies");
        }
        return new Money(this.amountUnit - other.amountUnit, this.currency);
    }

}