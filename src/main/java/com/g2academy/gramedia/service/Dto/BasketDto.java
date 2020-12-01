package com.g2academy.gramedia.service.Dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BasketDto {
    private CustomerDto customerDto;
}
