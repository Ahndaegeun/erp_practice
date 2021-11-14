package com.example.erp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Proxy {

    @Id @OneToOne
    private Role role;

    @OneToOne
    private Member member;
}