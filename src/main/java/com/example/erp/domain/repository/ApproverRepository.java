package com.example.erp.domain.repository;

import com.example.erp.domain.entity.Approver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproverRepository extends JpaRepository<Approver, Long> {
}
