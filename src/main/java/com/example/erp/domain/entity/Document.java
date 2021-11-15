package com.example.erp.domain.entity;

import com.example.erp.dto.DocumentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    private String title;
    private String content;

    public DocumentDTO entityToDto() {
        return DocumentDTO.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
}
