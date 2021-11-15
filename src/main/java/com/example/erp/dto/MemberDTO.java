package com.example.erp.dto;

import com.example.erp.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private Long id;
    private String memId;
    private String memPw;
    private String name;
    private LocalDateTime startWork;
    private LocalDateTime lastWork;

    public Member dtoToEntity() {
        return Member.builder()
                .id(id)
                .memId(memId)
                .memPw(memPw)
                .name(name)
                .startWork(startWork)
                .lastWork(lastWork)
                .build();
    }
}
