package com.g2academy.gramedia.service.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class WbDto {
    private Long warehouseId;
    private Long bookId;
    private String count;
}
