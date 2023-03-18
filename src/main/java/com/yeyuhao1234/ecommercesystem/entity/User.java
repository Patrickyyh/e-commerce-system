package com.yeyuhao1234.ecommercesystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "User"
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(
            name = "user_name",
            unique = true
    )
    private String userName;

    @Column(
            name = "email",
            unique = true
    )
    private String email;
    private String city;
    private String state;

    @Column(name ="phone_number",
            unique = true
    )
    private String phoneNumber;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private List<OrderDetail> orderDetails;


}
