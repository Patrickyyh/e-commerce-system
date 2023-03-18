package com.yeyuhao1234.ecommercesystem.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
 private Long orderId;
 private Long productId;
 private Long userId;
}
