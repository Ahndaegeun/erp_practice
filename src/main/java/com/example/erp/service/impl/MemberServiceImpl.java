package com.example.erp.service.impl;

import com.example.erp.domain.entity.Member;
import com.example.erp.domain.repository.MemberRepository;
import com.example.erp.dto.MemberDTO;
import com.example.erp.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {


        return null;
    }

    @Override
    public Member save(MemberDTO member) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setMemPw(passwordEncoder.encode(member.getMemPw()));
        return memberRepository.save(member.dtoToEntity());
    }

    @Override
    public Member login(MemberDTO member) {
        return memberRepository.findByMemIdAndMemPw(member.getMemId(), member.getMemPw());
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(long memId) {
        return memberRepository.findById(memId).get();
    }
}
