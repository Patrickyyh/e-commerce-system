package com.yeyuhao1234.ecommercesystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "ProductStat"
)
public class ProductStat {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long productStatId;
    private Long yearsSalesTotal;
    private Long yearlyTotalSoldUnits;

}
