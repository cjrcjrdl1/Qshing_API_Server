package com.min.shop.web.login;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {

    @NotBlank(message = "아이디를 입력하세오")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력하세요")
    private String password;
}
