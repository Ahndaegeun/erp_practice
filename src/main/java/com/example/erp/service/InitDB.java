package com.example.erp.service;

import com.example.erp.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitDB {

    public final InitService initService;

    @PostConstruct
    public void init() {
        initService.createMember("a001", "1234", "a001");
        initService.createMember("a002", "1234", "a002");
        initService.createMember("a003", "1234", "a003");
        initService.createMember("a004", "1234", "a004");
        initService.createMember("a005", "1234", "a005");
        initService.createMember("a006", "1234", "a006");
        initService.createMember("a007", "1234", "a007");
        initService.createMember("a008", "1234", "a008");
        initService.createMember("a009", "1234", "a009");
        initService.createMember("a010", "1234", "a010");
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void createMember(String memId, String memPw, String name) {
            Member member = Member.builder()
                    .memId(memId)
                    .memPw(memPw)
                    .name(name)
                    .startWork(LocalDateTime.now())
                    .build();
            em.persist(member);
        }
    }
}
