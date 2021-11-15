package com.example.erp.domain.repository;

import com.example.erp.domain.entity.SignMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignMemberRepository extends JpaRepository<SignMember, Long> {
}
