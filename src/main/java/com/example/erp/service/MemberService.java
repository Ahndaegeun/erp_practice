package com.example.erp.service;

import com.example.erp.domain.entity.Member;
import com.example.erp.dto.MemberDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public interface MemberService extends UserDetailsService {

    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException;
    public Member save(MemberDTO member);
    public Member login(MemberDTO member);
    public List<Member> findAll();
    public Member findById(long memId);
}
