package com.example.erp.controller;

import com.example.erp.domain.entity.Member;
import com.example.erp.dto.MemberDTO;
import com.example.erp.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberServiceImpl memberService;

    @PostMapping("/login")
    public String loginPro(MemberDTO member, Model model) {

        Member loginMember = memberService.login(member);

        if(loginMember != null) {
            model.addAttribute("member", loginMember.entityToDto());
            return "home";
        }
        return "redirect:/";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/signUp")
    public String signUpPro(MemberDTO member) {
        member.setStartWork(LocalDateTime.now());
        memberService.save(member);
        return "redirect:/";
    }

    @GetMapping("/proxy")
    public String proxy() {
        return "proxy";
    }

    @GetMapping("/vacation")
    public String vacation() {
        return "vacation";
    }
}
