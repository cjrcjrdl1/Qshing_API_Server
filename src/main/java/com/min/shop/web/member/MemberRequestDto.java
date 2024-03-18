package com.min.shop.web.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberRequestDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotBlank
    private String zipcode;

}
