package com.upskillwithsuraj.razorpay.payment.mapper;


import com.upskillwithsuraj.razorpay.payment.dto.response.PaymentResponse;
import com.upskillwithsuraj.razorpay.payment.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {

    @Mapping(target = "orderRecordId", source = "order.id")
    PaymentResponse toResponse(Payment payment);

//    source = "orderRecord.id" this is present inside the Payment.

    @Mapping(target = "orderRecordId", source = "order.id")
    List<PaymentResponse> toResponseList(List<Payment> paymentList);
}
