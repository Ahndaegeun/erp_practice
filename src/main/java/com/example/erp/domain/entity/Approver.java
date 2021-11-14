package com.example.erp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Approver {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "mem_id")
    private Member member;

    private String stat;
}
