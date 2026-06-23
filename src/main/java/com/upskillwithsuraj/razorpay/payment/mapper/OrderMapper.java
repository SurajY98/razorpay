package com.upskillwithsuraj.razorpay.payment.mapper;

import com.upskillwithsuraj.razorpay.payment.dto.response.CreateOrderResponse;
import com.upskillwithsuraj.razorpay.payment.entity.OrderRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    CreateOrderResponse toResponse(OrderRecord orderRecord);
}
