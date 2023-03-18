package com.yeyuhao1234.ecommercesystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "OrderDetail"
)
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private Date createdDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "orderHasProduct",
            joinColumns =
                    { @JoinColumn(name = "order_detail_id", referencedColumnName = "ID") },
            inverseJoinColumns =
                    { @JoinColumn(name = "product_id", referencedColumnName = "productId") })
    private Product product;


}