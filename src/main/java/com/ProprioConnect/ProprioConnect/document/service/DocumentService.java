package com.ProprioConnect.ProprioConnect.document.service;

import com.ProprioConnect.ProprioConnect.document.controler.DocumentControler;
import com.ProprioConnect.ProprioConnect.document.model.Document;
import com.ProprioConnect.ProprioConnect.document.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class DocumentService implements DocumentControler {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public ResponseEntity addFile(String auteur, String sujet, MultipartFile contenu) throws Exception {
        try{
            Document document = new Document();

            document.setAuteur(auteur);
            document.setSujet(sujet);
            document.setNomFichier(contenu.getOriginalFilename());
            document.setContenu(contenu.getBytes());

            documentRepository.save(document);

            return ResponseEntity.ok("le fichier a bien etait enregistrer");
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("le fichier a eu du mal a etre enregistrer");
        }
    }

    @Override
    public ResponseEntity getDocument(Long documentId) throws Exception {
        try{
           Document document = documentRepository.findDocumentById(documentId);
           return  ResponseEntity.ok(document);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("le fichier n'a pas etait trouver");
        }
    }

    @Override
    public ResponseEntity dowloadDocument(Long documentId) throws Exception {
        Document document = documentRepository.findDocumentById(documentId);
        try{
          InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(document.getContenu()));
          String type = this.checkTypeFile(document.getNomFichier());
          System.out.println(type);
          HttpHeaders headers = new HttpHeaders();
          headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + document.getNomFichier() + "." + type);

          return ResponseEntity.ok()
                  .headers(headers)
                  .contentType(MediaType.APPLICATION_OCTET_STREAM)
                  .body(resource);

      }catch (Exception e){
        throw new Exception("le fichier n'a pas pu etre telecharger", e);
      }
    }

    @Override
    public ResponseEntity deleteFile(Long documentId) throws Exception {
        try{
            documentRepository.deleteById(documentId);
            return  ResponseEntity.ok("le document a bien etait supprimer");
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("le fichier n'a pas etait trouver");
        }
    }

    public String checkTypeFile(String fileName){
        String[] nameTab = fileName.split("\\.");
        return nameTab[nameTab.length - 1];
    }
}
