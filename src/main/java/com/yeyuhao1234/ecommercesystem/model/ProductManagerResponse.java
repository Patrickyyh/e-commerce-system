package com.yeyuhao1234.ecommercesystem.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductManagerResponse {
    private Long productStatId;
    private Long productId;
}
