package com.example.erp.domain.entity;

import com.example.erp.dto.DocumentDTO;
import com.example.erp.dto.SignMemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sign_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private Document document;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    private State state;

    public SignMemberDTO entityToDto() {
        return SignMemberDTO.builder()
                .id(id)
                .memberDTO(member.entityToDto())
                .documentDTO(document.entityToDto())
                .position(position)
                .state(state)
                .build();
    }
}
