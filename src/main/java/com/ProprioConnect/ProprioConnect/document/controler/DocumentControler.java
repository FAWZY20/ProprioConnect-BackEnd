package com.ProprioConnect.ProprioConnect.document.controler;

import com.ProprioConnect.ProprioConnect.document.model.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public interface DocumentControler {

    @PostMapping("/document")
    public ResponseEntity addFile(@RequestParam("auteur") String auteur,
                                  @RequestParam("sujet") String sujet,
                                  @RequestParam("file") MultipartFile contenu) throws Exception;

    @GetMapping("/document/{documentId}")
    public ResponseEntity getDocument(@PathVariable("documentId") Long documentId) throws Exception;


    @GetMapping("/document/dowload/{documentId}")
    public ResponseEntity dowloadDocument(@PathVariable("documentId") Long documentId) throws Exception;

    @DeleteMapping("/document/{documentId}")
    public ResponseEntity deleteFile(@PathVariable("documentId") Long documentId) throws Exception;

}
