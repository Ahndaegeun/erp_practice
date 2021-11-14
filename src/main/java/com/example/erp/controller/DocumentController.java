package com.example.erp.controller;

import com.example.erp.domain.entity.Approver;
import com.example.erp.domain.entity.Document;
import com.example.erp.domain.entity.Member;
import com.example.erp.service.ApproverService;
import com.example.erp.service.DocumentService;
import com.example.erp.service.MemberService;
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
@RequestMapping("/doc")
@RequiredArgsConstructor
public class DocumentController {

    private final MemberService memberService;
    private final DocumentService documentService;
    private final ApproverService approverService;

    private final Logger logger = LoggerFactory.getLogger(DocumentController.class);

    @GetMapping("/write")
    public String write(Model model) {
        logger.info("get write >>>>>>>>>>>>>");
        List<Member> memberList = memberService.findAll();

        model.addAttribute("list", memberList);
        return "writeDoc";
    }

    @PostMapping("/write")
    public String writePro(@RequestParam Map<String, Object> map) {

        Member member = memberService.findById(Long.parseLong(map.get("memId") + ""));

        Document document = new Document(null, member, map.get("title") + "", map.get("content") + "");
        document = documentService.saveDocument(document);

        member = memberService.findById(Long.parseLong(map.get("p1") + ""));
        Approver p1 = approverService.save(new Approver(null, document, member, "N"));

        member = memberService.findById(Long.parseLong(map.get("p2") + ""));
        Approver p2 = approverService.save(new Approver(null, document, member, "N"));

        member = memberService.findById(Long.parseLong(map.get("p3") + ""));
        Approver p3 = approverService.save(new Approver(null, document, member, "N"));

        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Approver> approverList = approverService.findAll();

        model.addAttribute("list", approverList);
        return "docList";
    }

    @GetMapping("/ok")
    public String ok(String id) {
        Approver approver = approverService.findById(Long.parseLong(id));

        if(approver.getMember().getStat().equals("Y")) {
            // 권한이 전결이면 모든 결재선 결재 완료
            Member member = approver.getMember();


            // 권한이 전결이 아니면 해당 맴버만 결재 완료

        } else {
            // 맴버 상태가 N 이면 대결 맴버 찾아서 결재완료 후 결재자 변경

        }

        return "redirect:/doc/list";
    }

    @GetMapping("/no")
    public String no(@RequestParam Map<String, Object> map) {



        return "redirect:/doc/list";
    }
}
