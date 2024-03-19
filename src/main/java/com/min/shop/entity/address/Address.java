package com.min.shop.entity.address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    private String address;

    // 안전한지 여부
    private boolean isSafe;

    // GPS
    private String gps;
}
