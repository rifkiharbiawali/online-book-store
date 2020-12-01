package com.g2academy.gramedia.service.Dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BbDto {
    private BookDto bookDto;
    private BasketDto basketDto;
    private String count;
}
