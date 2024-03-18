package com.min.shop.web;

import com.min.shop.web.member.MemberResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
public class HomeController {
    @RequestMapping("/")
    public String home(@SessionAttribute(name = "loginMember", required = false) MemberResponseDto memberResponseDto, Model model) {

        if (memberResponseDto == null) {
            log.info("home controller");
            return "index";
        }

        model.addAttribute("member", memberResponseDto);
        return "loginIndex";
    }

}
