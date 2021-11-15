package com.example.erp.dto;

import com.example.erp.domain.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignMemberDTO {

    private Long id;
    private MemberDTO memberDTO;
    private DocumentDTO documentDTO;
    private Position position;
    private State state;

    public SignMember dtoToEntity() {
        return SignMember.builder()
                .id(id)
                .member(memberDTO.dtoToEntity())
                .document(documentDTO.dtoToEntity())
                .position(position)
                .state(state)
                .build();
    }
}
