package com.g2academy.gramedia.service.Dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class WbDto {
    private WarehouseDto warehouseDto;
    private BookDto bookDto;
    private String count;
}
