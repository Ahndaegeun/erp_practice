package com.example.erp.controller;

import com.example.erp.domain.entity.*;
import com.example.erp.dto.DocumentDTO;
import com.example.erp.dto.SignMemberDTO;
import com.example.erp.service.DocumentService;
import com.example.erp.service.impl.MemberServiceImpl;
import com.example.erp.service.SignMemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {

    private final Logger logger = LoggerFactory.getLogger(DocumentController.class);

    private final MemberServiceImpl memberService;
    private final DocumentService documentService;
    private final SignMemberService signMemberService;

    @GetMapping("/write")
    public String write(Model model) {
        List<Member> memberList = memberService.findAll();

        model.addAttribute("memberList", memberList);
        return "write";
    }

    @PostMapping("/write")
    public String writePro(DocumentDTO document, @RequestParam Map<String, Object> map) {

        Member member = memberService.findById(document.getMemberDTO().getId());
        document.setMemberDTO(member.entityToDto());

        Document resultDoc = documentService.save(document.dtoToEntity());

        for(String key : map.keySet()) {
            if(key.contains("Sign")) {
                Member mem = memberService.findById(Long.parseLong(map.get(key) + ""));

                SignMemberDTO sm = new SignMemberDTO();
                sm.setState(State.WAIT);
                sm.setMemberDTO(mem.entityToDto());
                sm.setDocumentDTO(resultDoc.entityToDto());
                sm.getDocumentDTO().setMemberDTO(mem.entityToDto());

                if(key.contains("first")) {
                    sm.setPosition(Position.FIRST);
                } else if(key.contains("middle")) {
                    sm.setPosition(Position.MIDDLE);
                } else {
                    sm.setPosition(Position.LAST);
                }

                signMemberService.save(sm.dtoToEntity());
            }
        }
        return "home";
    }

    @GetMapping("/mydoc")
    public String mydoc() {
        return "mydoc";
    }

    @GetMapping("/signdoc")
    public String signdoc() {
        return "signdoc";
    }
}
