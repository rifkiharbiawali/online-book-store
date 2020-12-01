package com.g2academy.gramedia.service.Dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class WarehouseDto {
    private String phone;
    private String address;
}
