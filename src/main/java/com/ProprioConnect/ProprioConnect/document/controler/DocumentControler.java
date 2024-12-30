package com.ProprioConnect.ProprioConnect.document.controler;

import com.ProprioConnect.ProprioConnect.document.model.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public interface DocumentControler {

    @PostMapping("/document")
    public ResponseEntity addFile(@RequestParam("auteur") Long auteur,
                                  @RequestParam("destinataire") Long destinataire,
                                  @RequestParam("sujet") String sujet,
                                  @RequestParam("file") MultipartFile contenu) throws Exception;

    @GetMapping("/document/{documentId}")
    public ResponseEntity getDocumentById(@PathVariable("documentId") Long documentId) throws Exception;


    @GetMapping("/document/destinataire/{destinataireId}")
    public ResponseEntity getDocumentByDestinataireId(@PathVariable("destinataireId") Long destinataireId) throws Exception;

    @GetMapping("/document/auteur/{auteurId}")
    public ResponseEntity getDocumentByauteurId(@PathVariable("auteurId") Long auteurId) throws Exception;


    @GetMapping("/document/dowload/{documentId}")
    public ResponseEntity dowloadDocument(@PathVariable("documentId") Long documentId) throws Exception;

    @DeleteMapping("/document/{documentId}")
    public ResponseEntity deleteFile(@PathVariable("documentId") Long documentId) throws Exception;

}
