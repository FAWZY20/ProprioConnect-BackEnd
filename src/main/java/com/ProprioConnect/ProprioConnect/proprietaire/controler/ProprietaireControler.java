package com.ProprioConnect.ProprioConnect.proprietaire.controler;

import com.ProprioConnect.ProprioConnect.proprietaire.model.Proprietaire;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface ProprietaireControler {

    @PostMapping("/proprietaire")
    public ResponseEntity addProprietaire(@RequestBody Proprietaire proprietaire) throws Exception;

    @GetMapping("/proprietaire/{propId}")
    public ResponseEntity getProprietaire(@PathVariable("propId") Long propId) throws Exception;

    @DeleteMapping("/proprietaire/{propId}")
    public ResponseEntity deleteProprietaire(@PathVariable("propId") Long propId) throws Exception;

}
