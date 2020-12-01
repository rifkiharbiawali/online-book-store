package com.g2academy.gramedia.service.Dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CustomerDto {
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String address;
}
