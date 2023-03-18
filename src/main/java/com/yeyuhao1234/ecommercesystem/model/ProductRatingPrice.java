package com.yeyuhao1234.ecommercesystem.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRatingPrice {
    private Long productId;
    private String name;
    private Long price;
    private String description;
    private Long rating;
}
