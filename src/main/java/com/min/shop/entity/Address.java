package com.min.shop.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() { //임베디드 타입은 자바 기본생성자를 public 혹은 protected로 설정해야함
    }// public 보단 protected 가 더 안전

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
