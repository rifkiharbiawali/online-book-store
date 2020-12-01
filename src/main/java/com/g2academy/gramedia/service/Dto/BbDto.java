package com.g2academy.gramedia.service.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class BbDto {
    private Long bookId;
    private Long basketId;
    private String count;
}
