package com.example.erp.domain.entity;

import com.example.erp.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String memId;
    private String memPw;
    private String name;

    private LocalDateTime startWork;
    private LocalDateTime lastWork;

    public MemberDTO entityToDto() {
        return MemberDTO.builder()
                .id(id)
                .memId(memId)
                .memPw(memPw)
                .name(name)
                .startWork(startWork)
                .lastWork(lastWork)
                .build();
    }
}
