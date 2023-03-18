package com.yeyuhao1234.ecommercesystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.LongAccumulator;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderQuantityResponse {

    private Long userId;
    private String userName;
    private Long quantity_of_order;
}
