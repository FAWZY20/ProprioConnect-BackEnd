package com.ProprioConnect.ProprioConnect.locataire.controler;


import com.ProprioConnect.ProprioConnect.locataire.model.Locataire;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface LocataireControler {

    @PostMapping("/locataire")
    public ResponseEntity addlocataire(@RequestBody Locataire locataire) throws Exception;

    @GetMapping("/locataire/{locataireId}")
    public ResponseEntity getlocataire(@PathVariable("locataireId") Long locataireId) throws Exception;

    @DeleteMapping("/locataire/{locataireId}")
    public ResponseEntity deletelocataire(@PathVariable("locataireId") Long locataireId) throws Exception;
}
