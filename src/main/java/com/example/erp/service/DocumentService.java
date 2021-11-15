package com.example.erp.service;

import com.example.erp.domain.entity.Document;
import com.example.erp.domain.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final Logger logger = LoggerFactory.getLogger(DocumentService.class);
    private final DocumentRepository documentRepository;


    public Document save(Document document) {
        return documentRepository.save(document);
    }
}
