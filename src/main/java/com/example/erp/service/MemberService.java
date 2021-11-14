package com.example.erp.service;

import com.example.erp.domain.entity.Member;
import com.example.erp.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
    public Member findById(Long memId) {
        return memberRepository.findById(memId).get();
    }
}
