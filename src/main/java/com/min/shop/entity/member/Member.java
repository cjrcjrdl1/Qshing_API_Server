package com.min.shop.entity.member;

import com.min.shop.entity.Address;
import com.min.shop.entity.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String name;
    private String password;

    @Embedded
    private Address address;

    @OneToMany(mappedBy ="member")
    private List<Order> orders = new ArrayList<>();

}
