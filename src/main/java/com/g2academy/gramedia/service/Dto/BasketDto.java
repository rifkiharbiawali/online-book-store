package com.g2academy.gramedia.service.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class BasketDto {
    private Long customerId;
}
