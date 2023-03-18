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
      name = "Product"
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "product_stat_id",referencedColumnName ="productStatId" )
    private ProductStat productStat;

    private String name;
    private Long price;
    private String description;
    private Long rating;



}
