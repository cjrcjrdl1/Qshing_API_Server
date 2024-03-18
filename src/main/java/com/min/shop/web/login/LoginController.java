package com.min.shop.web.login;

import com.min.shop.entity.member.Member;
import com.min.shop.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping(value = "/login")
    public String loginForm(@ModelAttribute("login") LoginDto form) {
        return "members/loginForm";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("login") LoginDto form, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request) {

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if (form.getLoginId() != null && form.getPassword() != null) {
            if (loginMember == null) {
                bindingResult.reject("loginError");
            }
        }

        if (bindingResult.hasErrors()) {
            return "members/loginForm";
        }


        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);

        return "redirect:" + redirectURL;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); //세션 없으면 null 반환
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
