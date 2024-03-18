package com.min.shop.service;

import com.min.shop.entity.Address;
import com.min.shop.entity.member.Member;
import com.min.shop.entity.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LoginServiceTest {

    @Autowired
    LoginService loginService;

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void login() {
        //given
        Member member = new Member();
        member.setLoginId("a");
        member.setPassword("a");
        member.setName("a");
        member.setAddress(new Address("a", "a", "a"));
        memberService.join(member);

        //when
        Member loginMember = loginService.login("a", "a");

        //then
        assertEquals(loginMember, member);

    }
}