package com.example.erp.service;

import com.example.erp.domain.entity.Approver;
import com.example.erp.domain.repository.ApproverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApproverService {

    private final ApproverRepository approverRepository;

    public Approver save(Approver approver) {
        return approverRepository.save(approver);
    }

    public List<Approver> findAll() {
        return approverRepository.findAll();
    }

    public Approver findById(Long id) {
        return approverRepository.findById(id).get();
    }
}
