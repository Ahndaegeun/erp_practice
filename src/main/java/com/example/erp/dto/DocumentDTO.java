package com.example.erp.dto;

import com.example.erp.domain.entity.Document;
import com.example.erp.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {

    private Long id;
    private MemberDTO memberDTO;
    private String title;
    private String content;

    public Document dtoToEntity() {
        return Document.builder()
                .id(id)
                .member(memberDTO.dtoToEntity())
                .title(title)
                .content(content)
                .build();
    }
}
