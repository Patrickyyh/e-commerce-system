package com.yeyuhao1234.ecommercesystem.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStatResponse {
    private Long productId;
    private Long productStatId;
    private String name;
    private Long yearlyTotalSoldUnits;
    private Long yearsSalesTotal;
}