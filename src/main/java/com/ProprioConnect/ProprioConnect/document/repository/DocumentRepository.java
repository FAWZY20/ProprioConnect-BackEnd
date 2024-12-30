package com.ProprioConnect.ProprioConnect.document.repository;

import com.ProprioConnect.ProprioConnect.document.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    Document findDocumentById(Long documentId);

    Document findDocumentByDestinataire(Long destinataire);

    Document findDocumentByAuteur(Long auteur);
}
