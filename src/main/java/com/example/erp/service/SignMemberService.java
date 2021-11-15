package com.example.erp.service;

import com.example.erp.domain.entity.SignMember;
import com.example.erp.domain.repository.SignMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignMemberService {

    private final SignMemberRepository signMemberRepository;

    public void save(SignMember signMember) {
        signMemberRepository.save(signMember);
    }
}
